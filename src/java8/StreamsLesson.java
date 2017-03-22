package java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamsLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        for(String s : list) {
            System.out.println(s);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Stream<String> stringStream = list.stream();
        stringStream.forEach(x -> System.out.println(x));
        for(String s : list) {
            if(s.equals("one")) {
                System.out.println(s);
            }
        }
        stringStream = list.stream();
        stringStream.filter(x -> x.equals("one")).forEach(x -> System.out.println(x));//only once

        stringStream = list.stream();
        Stream<String> stringStream1 = stringStream.filter((x) -> {
            System.out.println("hello");
            return x.equals("one");
        });//lazy
        stringStream1.forEach(x -> System.out.println(x));//eager

        Set<String> st = Stream.of("one", "two").collect(Collectors.toSet());//eager
        List<String> list1 = Stream.of("one", "two").map(x -> x.toUpperCase()).collect(Collectors.toList());
        List<String> list2 = Stream.of("one", "two").filter(x -> x.equals("one")).collect(Collectors.toList());
        List<String> list3 = Stream.of(asList("one", "two"), asList("three", "four")).flatMap(x -> x.stream()).collect(Collectors.toList());
        int value = Stream.of(1, 2).min(Comparator.comparing(x -> x)).get();
        int value2 = Stream.of(1, 2).max(Comparator.comparing(x -> x)).get();
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        int accomulator = 0;
        for(int element : new int[]{1,2,3}) {
            accomulator += element;
        }
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count2 = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);
        Stream.of("one", "two").sorted().collect(Collectors.toList());
        Stream.of("one", "two").limit(1).collect(Collectors.toList());
        Stream.of("one", "one").distinct().collect(Collectors.toList());
        Stream.of("one", "one").skip(1).collect(Collectors.toList());
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().get();
        Stream.of("one", "two").filter(x -> x.equals("one")).findAny().isPresent();
        Stream.of(1, 2).mapToInt(x -> x).sum();
        Stream.of(1, 2).count();
        Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get();

        IntStream intStream = Stream.of(1, 2).mapToInt(x -> x);
        intStream.summaryStatistics().getAverage();
    }
}