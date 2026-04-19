package org.cleancoding.thread;


public class DemoReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 3; i++) {
                counter.increment(name);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

//        t1.join();
//        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}