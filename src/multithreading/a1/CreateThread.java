package multithreading.a1;

/**
 * Created by max on 10/14/16.
 */
public class CreateThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new MyRunnuble());
        thread.start();
        //thread.start();

        new MyThread().start();
        Thread thread2 = new MyThread();
        thread2.start();
        thread2.run();
    }
}
class MyRunnuble implements Runnable {
    @Override
    public void run() {
        method();
    }

    private void method() {
        System.out.println(Thread.currentThread().getName());
        Thread.dumpStack();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
