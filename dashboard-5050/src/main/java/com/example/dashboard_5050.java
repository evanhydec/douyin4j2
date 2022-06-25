package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class dashboard_5050 {
    public static void main(String[] args) {
        SpringApplication.run(dashboard_5050.class,args);
    }
}

