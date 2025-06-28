package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Counter class using ReentrantLock for thread safety
class Counter4 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Always release the lock in the finally block
        }
    }

    public int getCount() {
        return count;
    }
}

// Thread that increments the counter
class ThreadDemo5 extends Thread {
    private final Counter4 counter;

    public ThreadDemo5(Counter4 counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

// Main class to run the threads
public class Task09 {
    public static void main(String[] args) {
        Counter4 counter = new Counter4();

        ThreadDemo5 t1 = new ThreadDemo5(counter);
        ThreadDemo5 t2 = new ThreadDemo5(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
