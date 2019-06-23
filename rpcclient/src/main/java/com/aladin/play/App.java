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
        //todo 该处也可以通过spring的方式进行加载
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", "8080");
        String result = helloService.sayHello("yang");
        System.out.println(result);
    }
}
