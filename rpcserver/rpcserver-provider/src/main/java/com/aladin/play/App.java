package com.aladin.play;


/**
 * Hello world!
 *
 */
public class App {
    private static final Integer port = 8080;
    public static void main( String[] args )
    {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(port);
    }
}
