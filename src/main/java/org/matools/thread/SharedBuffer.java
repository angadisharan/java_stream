package org.matools.thread;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait(); // release lock & wait
        }

        queue.add(value);
        System.out.println("Produced: " + value);

        notify(); // wake up consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer empty, consumer waiting...");
            wait(); // release lock & wait
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        notify(); // wake up producer
        return value;
    }
}