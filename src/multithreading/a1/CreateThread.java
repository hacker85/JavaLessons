package multithreading.a1;

/**
 * Created by max on 10/14/16.
 */
public class CreateThread {
    public static void main(String[] args) {
        new MyThread().start();
        Thread thread2 = new MyThread();
        thread2.start();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        try {
            throw new Exception();
        } catch (Exception e) {

        }
    }
}
