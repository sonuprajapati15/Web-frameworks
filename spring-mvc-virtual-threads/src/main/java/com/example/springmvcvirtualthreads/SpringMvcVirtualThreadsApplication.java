package com.example.springmvcvirtualthreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcVirtualThreadsApplication {
    public static void main(String[] args) {
        // Enable virtual threads (Java 21+ runtime)
        System.setProperty("spring.threads.virtual.enabled", "true");
        SpringApplication.run(SpringMvcVirtualThreadsApplication.class, args);
    }
}