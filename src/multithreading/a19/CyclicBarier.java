package multithreading.a19;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by husiv on 10/18/16.
 */
public class CyclicBarier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Run());
        new Sportsman(barrier);
        new Sportsman(barrier);
        new Sportsman(barrier);
    }
    static class Run extends Thread {
        @Override
        public void run() {
            System.out.println("Run is begun");
        }
    }
    static class Sportsman extends Thread {
        CyclicBarrier barrier;

        public Sportsman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + "await");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
