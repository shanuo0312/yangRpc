package com.aladin.play;

public class RpcNetTransport {
    private String ip;
    private int port;

    public RpcNetTransport(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String send() {
        return "";
    }
}
