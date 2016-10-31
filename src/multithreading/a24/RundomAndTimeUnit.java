package multithreading.a24;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by husiv on 10/18/16.
 */
public class RundomAndTimeUnit {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

        Thread.sleep(TimeUnit.HOURS.toMillis(5));
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
    }
}
