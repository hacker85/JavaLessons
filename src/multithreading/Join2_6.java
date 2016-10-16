package multithreading;

/**
 * Created by max on 10/14/16.
 */
public class Join2_6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3000; i++) {
                System.out.println(i);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            System.out.println(Thread.currentThread().getName());
        }
    }
}
