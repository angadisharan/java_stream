package org.matools.executor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {

        CompletableFuture<Void> t1 =
                CompletableFuture.runAsync(() -> runTask("Task1", false))
                        .exceptionally(ex -> {
                            System.out.println("Handled t1: " + ex.getMessage());
                            return null;
                        });

        CompletableFuture<Void> t2 =
                CompletableFuture.runAsync(() -> runTask("Task2", true));

        CompletableFuture<Void> t3 =
                CompletableFuture.runAsync(() -> runTask("Task3", false));

        CompletableFuture.anyOf(t1, t2, t3)
                .thenAccept(result -> {
                    System.out.println("First task finished");
                })
                .exceptionally(ex -> {
                    System.out.println("First task failed: " + ex.getMessage());
                    return null;
                })
                .handle((res, ex) -> {
                    System.out.println("Completed (success or failure)");
                    return null;
                })
                .join();
    }

    static void runTask(String name, boolean shouldFail) {
        System.out.println(name + " started");

        if (shouldFail) {
            throw new RuntimeException("Error in " + name);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " completed");
    }
}