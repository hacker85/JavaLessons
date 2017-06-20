package java8;

import java.time.*;

public class PeriodLesson {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2017, Month.JUNE, 25);
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localDate.plusDays(2));
        System.out.println(localTime);
        System.out.println(localTime.plusHours(2));
        System.out.println(localDateTime);

        System.out.println(localDate.plus(Period.ofDays(2)));
        System.out.println(localDate.plus(Period.ofMonths(2).ofDays(2)));
    }
}
