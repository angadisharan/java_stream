package org.cleancoding.thread;

class Consumer implements Runnable {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(800); // simulate work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}