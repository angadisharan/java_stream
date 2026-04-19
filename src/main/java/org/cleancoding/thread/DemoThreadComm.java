package org.cleancoding.thread;

import java.util.concurrent.locks.ReentrantLock;

public class DemoThreadComm {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(3);

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();


        ReentrantLock lock = new ReentrantLock();

    }
}
