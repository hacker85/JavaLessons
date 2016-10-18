package multithreading;

/**
 * Created by max on 10/14/16.
 */
public class Yield2_5 {
    public static void main(String[] args) throws InterruptedException {
        new MyThread().start();
        Thread.yield();
        System.out.println(Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
