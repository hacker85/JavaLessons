package java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocaDateLesson {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        localDate.plusDays(5);
        localDate.minusDays(5);
        System.out.println(localDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(dateTimeFormatter));
        LocalDate localDate1 = LocalDate.of(1990,12,31);
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.parse("23/03/2017", dateTimeFormatter);
        System.out.println(localDate2);
    }
}
