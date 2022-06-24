package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServer_3001 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer_3001.class,args);
    }
}
