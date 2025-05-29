package com.example.springmvctraditional.metric;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

@Component
public class MetricsLoggingRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        new Thread(() -> {
            try {
                while (true) {
                    // CPU load (if available)
                    double cpuLoad = -1.0;
                    if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
                        cpuLoad = ((com.sun.management.OperatingSystemMXBean) osBean).getProcessCpuLoad();
                    }
                    int liveThreads = threadBean.getThreadCount();
                    long[] threadIds = threadBean.getAllThreadIds();

                    System.out.println("=== JVM Metrics ===");
                    System.out.println("CPU Load: " + cpuLoad);
                    System.out.println("Live Threads: " + liveThreads);

                    // Print thread states summary
                    int runnable = 0, waiting = 0, timedWaiting = 0, blocked = 0, terminated = 0;
                    for (long id : threadIds) {
                        ThreadInfo info = threadBean.getThreadInfo(id);
                        if (info != null) {
                            switch (info.getThreadState()) {
                                case RUNNABLE: runnable++; break;
                                case WAITING: waiting++; break;
                                case TIMED_WAITING: timedWaiting++; break;
                                case BLOCKED: blocked++; break;
                                case TERMINATED: terminated++; break;
                            }
                        }
                    }
                    System.out.println("Runnable: " + runnable +
                            ", Waiting: " + waiting +
                            ", TimedWaiting: " + timedWaiting +
                            ", Blocked: " + blocked +
                            ", Terminated: " + terminated);

                    System.out.println("===================\n");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ignored) { }
        }).start();
    }
}