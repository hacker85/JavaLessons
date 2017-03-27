package multithreading.a26;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockLesson {
    public static void main(String[] args) {

    }
}
class Book {
    Lock lock = new ReentrantLock();
    String name;
    int buyTime;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();
    public void addBuy() {
        writeLock.lock();
        buyTime++;
        writeLock.lock();
    }
    public void howManyBooksWereSale() {
        readLock.lock();
        System.out.println("Books were sale " + buyTime);
        sendReport(buyTime);
        readLock.unlock();
    }
    private void sendReport(int books) {
        //..
    }
}
