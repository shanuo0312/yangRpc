package com.aladin.play;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    private Map<String, Class<?>> instanceContainer = new HashMap<String, Class<?>>();


    public void publisher(int port) {
        init();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(socket, null));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        instanceContainer.put(IHelloService.class.getName(), HelloServiceImpl.class);
    }
}
