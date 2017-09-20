package bestpractice;

import java.util.concurrent.TimeUnit;

public class SyncAccessToMutualData {
    private volatile static boolean stopRequested;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while (!stopRequested) {}
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
