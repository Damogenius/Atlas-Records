package Thread;

class Counter1 {
    private int count = 0;

    // Synchronized method to make increment thread-safe
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// Thread class that calls increment 1000 times
class ThreadDemo2 extends Thread {
    Counter1 counter;

    ThreadDemo2(Counter1 counter) {
        this.counter = counter;
    }
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
// Main class to run the threads
public class Task06 {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();

        ThreadDemo2 t1 = new ThreadDemo2(counter);
        ThreadDemo2 t2 = new ThreadDemo2(counter);

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

