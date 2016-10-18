package multithreading.a12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by max on 10/16/16.
 */
public class TryLock {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
    static class Thread1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " start working");
            while(true) {
                if(lock.tryLock()) {
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + " waiting");
                }
            }
        }
    }
}
