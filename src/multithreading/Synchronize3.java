package multithreading;

/**
 * Created by max on 10/14/16.
 */
public class Synchronize3 {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();

        Thread thread1 = new SyncThread(resource);
        Thread thread2 = new SyncThread(resource);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resource.getI());
    }
}

class SyncThread extends Thread {
    Resource resource;

    public SyncThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
    private int i;

    public int getI() {
        return i;
    }

    public void changeI() {
        int i = this.i;
        if(Thread.currentThread().getName().equals("Thread-0")) {
            Thread.yield();
        }
        i++;
        this.i = i;
    }
}
