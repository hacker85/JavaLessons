package bestpractice;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

//how to make immutable
//1. no setters
//2. private final fields
//3. final class
//4. don't return mutable objects
//advantages - simple, thread safe no sync, good for cashing,
//final class
//final fields
//Date -> LocalDate
public class ImmutableLesson {
    private final int i;

    private ImmutableLesson(int i) {
        this.i = i;
    }

    public static ImmutableLesson getInstance(int i) {
        return new ImmutableLesson(i);
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        Point point;
        Date date;
        LocalDate localDate;
    }
}
