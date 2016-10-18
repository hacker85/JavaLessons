package multithreading.a6;

/**
 * Created by max on 10/16/16.
 */
public class Atomic {

    static int i;
    //static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new AtomicThread().start();
        }
        Thread.sleep(2000);
        System.out.println(i);
        //System.out.println(atomicInteger.get());
    }

    static class AtomicThread extends Thread {
        @Override
        public void run() {
            i++;
            //atomicInteger.incrementAndGet();
        }
    }
}
