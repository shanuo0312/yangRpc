package com.aladin.play;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", "8080");
        helloService.sayHello("yang");
    }
}
