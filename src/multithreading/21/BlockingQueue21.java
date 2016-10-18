package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by husiv on 10/18/16.
 */
public class BlockingQueue21 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                queue.add("this is string");
            }
        }.start();
    }
}
