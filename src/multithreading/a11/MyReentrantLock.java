package multithreading.a11;

import java.util.concurrent.locks.Lock;

/**
 * Created by max on 10/16/16.
 */
public class MyReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource();

        ReentrantThread reentrantThread = new ReentrantThread();
        reentrantThread.setName("one");
        ReentrantThread reentrantThread2 = new ReentrantThread();

        reentrantThread.myResource = myResource;
        reentrantThread2.myResource = myResource;

        reentrantThread.start();
        reentrantThread2.start();

        reentrantThread.join();
        reentrantThread2.join();
        System.out.println(myResource.i);
        System.out.println(myResource.j);
    }
    static class ReentrantThread extends Thread {
        MyResource myResource;

        @Override
        public void run() {
            myResource.changeI();
            myResource.changeJ();
        }
    }
}

class MyResource {
    int i;
    int j;
    Lock lock = new java.util.concurrent.locks.ReentrantLock();
    void changeI() {
        lock.lock();
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        this.i = ++i;
        //changeJ();
    }
    void changeJ() {
        int j = this.j;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        this.j = ++j;
        lock.unlock();
    }
}
