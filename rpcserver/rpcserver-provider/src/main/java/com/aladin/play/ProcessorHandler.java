package com.aladin.play;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessorHandler implements Runnable{
    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest)objectInputStream.readObject();

            Object result = invoke(rpcRequest);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

        } catch (Exception e) {
            if(objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if(objectInputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object[] args = rpcRequest.getParameters();
        Class<?>[] types = new Class[args.length];
        for(int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        Class clazz = Class.forName(rpcRequest.getClassName());
        Method method = clazz.getMethod(rpcRequest.getMethodName(), types);
        Object object = method.invoke(clazz.newInstance(), args);
        return object;
    }
}
