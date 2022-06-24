package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer_6060 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_6060.class,args);
    }
}
