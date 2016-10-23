package multithreading.a15;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by husiv on 10/18/16.
 */
public class SheduledExecutionService {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new MyThread(), 2, TimeUnit.SECONDS);
        service.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
