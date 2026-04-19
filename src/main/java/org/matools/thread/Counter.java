package org.matools.thread;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(String threadName) {
        lock.lock(); // acquire lock
        try {
            System.out.println(threadName + " acquired lock");

            int temp = count;
            // simulate some work
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            count = temp + 1;
            System.out.println(threadName + " updated count to " + count);

        } finally {
            System.out.println(threadName + " releasing lock");
            lock.unlock(); // always release
        }
    }

    public int getCount() {
        return count;
    }
}
