package multithreading;

/**
 * Created by max on 10/16/16.
 */
public class Deadlock8 {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        DeadThread1 deadThread1 = new DeadThread1();
        DeadThread2 deadThread2 = new DeadThread2();
        deadThread1.resourceA = resourceA;
        deadThread2.resourceB = resourceB;
        deadThread1.start();
        deadThread2.start();
    }
}

class DeadThread1 extends Thread {
    ResourceA resourceA;
    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class DeadThread2 extends Thread {
    ResourceB resourceB;
    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;
    public synchronized int getI() {
        return resourceB.returnI();
    }
    public synchronized int returnI() {
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;
    public synchronized int getI() {
        return resourceA.returnI();
    }
    public synchronized int returnI() {
        return 2;
    }
}