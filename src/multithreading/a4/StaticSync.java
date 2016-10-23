package multithreading.a4;

/**
 * Created by max on 10/14/16.
 */
public class StaticSync {
    public static void main(String[] args) throws InterruptedException {
        StaticResource resource = new StaticResource();

        Thread thread1 = new StaticSyncThread(resource);
        Thread thread2 = new StaticSyncThread(resource);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(StaticResource.i);
    }
}

class StaticSyncThread extends Thread {
    StaticResource resource;

    public StaticSyncThread(StaticResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
        resource.changeStaticI();
    }
}

class StaticResource {
    static int i;

    public void changeI() {
        synchronized (this) {
            int i = StaticResource.i;
            if (Thread.currentThread().getName().equals("Thread-0")) {
                Thread.yield();
            }
            i++;
            StaticResource.i = i;
        }
    }
    public static void changeStaticI() {
        synchronized (StaticResource.class) {
            int i = StaticResource.i;
            if(Thread.currentThread().getName().equals("Thread-0")) {
                Thread.yield();
            }
            i++;
            StaticResource.i = i;
        }
    }
}