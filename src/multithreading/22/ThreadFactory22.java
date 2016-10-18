package multithreading;

import java.util.concurrent.ThreadFactory;

/**
 * Created by husiv on 10/18/16.
 */
public class ThreadFactory22 {
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };

        factory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
