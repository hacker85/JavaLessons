package multithreading;

import java.util.concurrent.Phaser;

/**
 * Created by husiv on 10/18/16.
 */
public class Phaser20 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }
    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
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
