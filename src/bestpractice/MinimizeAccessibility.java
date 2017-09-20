package bestpractice;

import java.awt.*;
import java.math.BigInteger;

//modules developed, tested, optimized, used, understood, and modified in isolation
//this is speedup development
//easier to understand
//easier find bugs and performance issues
//make each class or member as inaccessible as possible
//classes and fields
//package vs protected
//make all private, if need package, if need protected -> public //maybe redesign
//public = forever -> all interfaces is public
//It is acceptable to make a private member of a public class package-private in order to test it, but it is not acceptable to raise the accessibility any higher than that.
//Instance fields should never be public //except final and immutable //make static
public class MinimizeAccessibility {
    public static final int i = 5;
    public static void main(String[] args) {
        Point point;
        BigInteger bigInteger;
    }

    public int getI() {
        return i;
    }
}

final class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    public final int hour;
    public final int minute;
    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
    }
}
