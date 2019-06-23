package com.aladin.play;

public class HelloServiceImpl implements IHelloService {
    public String sayHello(String content) {
        System.out.println("request in sayHello:" + content);
        return "say Hello:" + content;
    }

    public String saveUser(User user) {
        System.out.println("request in saveUser:" + user);
        return "SUCCESS";
    }
}
