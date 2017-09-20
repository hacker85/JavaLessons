package bestpractice;

import java.util.Date;

//copy when return
//copy when use
//don't use clone
//check after and check on ended params //time-of-check time-of-use race condition
//use long
public class CopyInImmutableObjects {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
    }
}

final class Period {
    private final long start;
    private final long end;

    /**
     * @param start the beginning of the period
     * @param end   the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException     if start or end is null
     */
    public Period(Date start, Date end) {
        this.start = start.getTime();
        this.end = end.getTime();
        if (this.start < this.end)
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return new Date(start);
    }
    public Date end() {
        return new Date(end);
    }
}
//class MyDate extends Date {
//    @Override
//    public Object clone() {
//        //some bad code
//        return super.clone();
//    }
//}