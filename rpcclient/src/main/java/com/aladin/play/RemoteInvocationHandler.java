package com.aladin.play;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String ip;
    private String port;

    public RemoteInvocationHandler(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);

        RpcNetTransport rpcNetTransport = new RpcNetTransport(ip, Integer.valueOf(port));
        String result = rpcNetTransport.send();

        return null;
    }
}
