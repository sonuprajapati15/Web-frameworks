package com.example.springmvctraditional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class WorkloadController {

    @GetMapping("/cpu")
    public String cpuBound() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        for (int i = 0; i < cores; i++) {
            pool.submit(() -> {
                long x = 0;
                for (int j = 0; j < 10_000_000; j++) {
                    x += Math.sqrt(j);
                }
            });
        }
        pool.shutdown();
        return "CPU-bound task started!";
    }

    @GetMapping("/io")
    public String ioBound() {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            pool.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {}
            });
        }
        pool.shutdown();
        return "IO-bound task started!";
    }
}