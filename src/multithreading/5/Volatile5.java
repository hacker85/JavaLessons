package multithreading;

/**
 * Created by max on 10/15/16.
 */
public class Volatile5 {

    static int i;

    public static void main(String[] args) {
        new ReadThread().start();
        new WriteThread().start();
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            while(i < 5) {
                System.out.println("increase i " + (++i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReadThread extends Thread {
        @Override
        public void run() {
            int localValue = i;
            while (localValue < 5){
                if(localValue != i) {
                    System.out.println(localValue = i);
                }
            }
        }
    }
}
