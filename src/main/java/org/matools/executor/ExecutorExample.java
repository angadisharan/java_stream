package org.matools.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> runTask("Task1", true));
        executor.submit(() -> runTask("Task2", false));
        executor.submit(() -> runTask("Task3", false));

        executor.shutdown();
    }

    static void runTask(String name, boolean shouldFail) {
        try {
            System.out.println(name + " started");

            if (shouldFail) {
                throw new RuntimeException("Error in " + name);
            }

            Thread.sleep(1000);
            System.out.println(name + " completed");

        } catch (Exception e) {
            System.out.println(name + " failed: " + e.getMessage());
        }
    }
}
