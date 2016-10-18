package multithreading.a17;

import java.util.concurrent.CountDownLatch;

/**
 * Created by husiv on 10/18/16.
 */
public class CountDownLounch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();
        System.out.println("all jobs done");
    }

    static class Work extends Thread {
        CountDownLatch countDownLatch;

        public Work(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            start();
        }

        @Override
        public void run() {
            System.out.println("do some job");
            System.out.println("done work");
            countDownLatch.countDown();
        }
    }
}
