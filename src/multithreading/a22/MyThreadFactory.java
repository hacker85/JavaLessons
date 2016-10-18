package multithreading.a22;

/**
 * Created by husiv on 10/18/16.
 */
public class MyThreadFactory {
    public static void main(String[] args) {
        java.util.concurrent.ThreadFactory factory = new java.util.concurrent.ThreadFactory() {
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
