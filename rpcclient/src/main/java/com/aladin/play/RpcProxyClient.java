package com.aladin.play;

import java.lang.reflect.Proxy;

public class RpcProxyClient {
    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final String port) {
        return  (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
