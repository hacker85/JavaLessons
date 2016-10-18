package multithreading.a23;

import java.util.Date;

/**
 * Created by husiv on 10/18/16.
 */
public class ForkJoinFramework {
    static long numOfOperations = 10_000_000_000L;
    public static void main(String[] args) {
        System.out.println(new Date());
        long j = 0;
        for (long i = 0; i < numOfOperations; i++) {
            j += i;
        }
        System.out.println(j);
        System.out.println(new Date());
    }
}
