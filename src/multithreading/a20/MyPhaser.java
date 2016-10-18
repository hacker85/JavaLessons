package multithreading.a20;

/**
 * Created by husiv on 10/18/16.
 */
public class MyPhaser {
    public static void main(String[] args) {
        java.util.concurrent.Phaser phaser = new java.util.concurrent.Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }
    static class Washer extends Thread {
        java.util.concurrent.Phaser phaser;

        public Washer(java.util.concurrent.Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
                System.out.println(getName() + " pollish the car");
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
