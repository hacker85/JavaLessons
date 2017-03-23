package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ParallelismLesson {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1","2").parallel();
        List<String> list = new ArrayList<>();
        list.parallelStream();

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list2.add(i);
            list2.add(10_000_000 - i);
        }
        System.out.println(new Date());
//        list2.stream().parallel().filter(x -> x%2 == 0).map(x -> new Double(x)).forEach(x -> x.toString());
        list2.stream().sorted().count();
        System.out.println(new Date());

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(4);
        list3.add(2);
        list3.add(3);
        list3.add(2);
        list3.add(5);
        List<Stud> list4 = new ArrayList<>();//LinkedList
        list4.add(new Stud("Max"));
        list4.add(new Stud("Mike"));

        System.out.println(new Date().getTime());
        list4.stream().map(Stud::getName).count();
        System.out.println(new Date().getTime());

        int size = 10;
        double[] values = new double[size];
        for(int i = 0; i < values.length;i++) {
            values[i] = i;
        }
        double[] values2 = new double[size];
        Arrays.parallelSetAll(values2, i -> i);

        List<Integer> studs = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            studs.add(i);
        }
        studs.stream().forEach(x -> System.out.println(x));
    }
}
class Stud {
    String name;
    String surname;

    public Stud(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}