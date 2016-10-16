package multithreading;

/**
 * Created by max on 10/14/16.
 */
public class LiveCycle2 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        Thread myThread = new MyThread();
        myThread.interrupt();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
