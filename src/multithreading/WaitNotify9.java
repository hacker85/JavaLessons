package multithreading;

/**
 * Created by max on 10/16/16.
 */
public class WaitNotify9 {
    public static void main(String[] args) throws InterruptedException {
        ThreadB threadb = new ThreadB();
        threadb.start();
        synchronized (threadb) {
            threadb.wait();
        }
        System.out.println(threadb.total);
    }
    static class ThreadB extends Thread {
        int  total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}
