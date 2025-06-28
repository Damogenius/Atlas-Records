package Thread;
// Counter class using static synchronized method
class Counter3 {
    private static int count = 0;
    // Static synchronized method locks on the class (Counter.class)
    public static synchronized void increment() {
        count++;
    }
    public static int getCount() {
        return count;
    }
}
// Thread class using the static increment
class ThreadDemo4 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter3.increment(); // Call static synchronized method
        }
    }
}

public class Task08 {
    public static void main(String[] args) {
        ThreadDemo4 t1 = new ThreadDemo4();
        ThreadDemo4 t2 = new ThreadDemo4();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + Counter3.getCount());
    }
}
