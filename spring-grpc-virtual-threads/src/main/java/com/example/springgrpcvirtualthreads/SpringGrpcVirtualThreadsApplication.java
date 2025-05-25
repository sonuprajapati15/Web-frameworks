package com.example.springgrpcvirtualthreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGrpcVirtualThreadsApplication {
    public static void main(String[] args) {
        System.setProperty("spring.threads.virtual.enabled", "true"); // Enable virtual threads in Spring Boot 3.2+
        SpringApplication.run(SpringGrpcVirtualThreadsApplication.class, args);
    }
}