package multithreading.a13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by max on 10/17/16.
 */
public class Conditions {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;
    public static void main(String[] args) {
        new AccountPlus().start();
        new AccountMinus().start();
    }
    static class AccountPlus extends Thread {
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }
    static class AccountMinus extends Thread {
        @Override
        public void run() {
            if(account < 10) {
                try {
                    lock.lock();
                    System.out.println("account = " + account);
                    condition.await();
                    System.out.println("account = " + account);
                    lock.unlock();
                } catch (InterruptedException e) {
                }
            }
            account -= 10;
            System.out.println("account at the end = " + account);
        }
    }
}
