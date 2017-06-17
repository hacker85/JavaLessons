package multithreading.a6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by max on 10/16/16.
 */
public class Atomic {

//    static int i;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new AtomicThread().start();
        }
        Thread.sleep(1000);
//        System.out.println(i);
        System.out.println(atomicInteger.get());
    }

    static class AtomicThread extends Thread {
        @Override
        public void run() {
//            i++;
//            i = i + 1;
            atomicInteger.incrementAndGet();
        }
    }
}
