package bestpractice;

import java.util.*;

public class UnnecessaryObjects {
    public static void main(String[] args) {
        Object o;
        String str = new String("string");// wrong!
        String str2 = "string";

        Map map = new HashMap<>();
        map.keySet();

        long begin = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - begin);

        UnnecessaryObjects unnecessaryObjects = new UnnecessaryObjects();
//        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            unnecessaryObjects.isBabyBoomer(new Date());
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    public boolean isBabyBoomer(Date birthDate) {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

//    private static final Date BOOM_START;
//    private static final Date BOOM_END;
//    static {
//        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
//        BOOM_START = gmtCal.getTime();
//        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
//        BOOM_END = gmtCal.getTime();
//    }
//    public boolean isBabyBoomer(Date birthDate) {
//        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
//    }
}
