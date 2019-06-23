package com.aladin.play;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.aladin.play")
public class SpringConfig {
    @Bean
    public YangRpcServer yangRpcServer() {
        return new YangRpcServer(8080);
    }
}
