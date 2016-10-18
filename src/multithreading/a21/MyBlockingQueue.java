package multithreading.a21;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by husiv on 10/18/16.
 */
public class MyBlockingQueue {
    public static void main(String[] args) {
        java.util.concurrent.BlockingQueue<String> queue = new PriorityBlockingQueue<>();

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
