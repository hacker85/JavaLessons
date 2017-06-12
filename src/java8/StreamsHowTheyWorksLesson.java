package java8;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsHowTheyWorksLesson {
    public static void main(String[] args) {
        //Processing Order
        Stream<String> stream = Stream.of("a", "c", "b");
        stream.map(s -> s.toUpperCase());
        stream.map(s -> s.toUpperCase())
                .filter(s -> s.equals("a"))
                .forEach(s -> System.out.println(s));

        stream.map((s) -> {
            System.out.println("first map: " + s);
            return s + 1;
        }).map((s) -> {
            System.out.println("second map: " + s);
            return s.toUpperCase();})
                .forEach(s -> System.out.println(s));

        stream.sorted((s1, s2) -> {
            System.out.println("sort s1: " + s1 + " s2: " + s2);
            return s1.compareTo(s2);
        }).map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        }).forEach(s -> System.out.println(s));

        //Reusing Streams
        Stream<String> stream2 = Stream.of("a", "b", "c");
        Supplier<Stream<String>> supplier = () -> Stream.of("a", "b", "c");
        stream2.forEach(s -> System.out.println(s));
        stream2.forEach(s -> System.out.println(s));

        //Parallel streams
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());

        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.parallel()
                .map(s -> {
                    System.out.println("Map: " + s + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
                    return s.toUpperCase();
                })
                .map(s -> {
                    System.out.println("Map2: " + s + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
                    return s.toLowerCase();
                })
                .sorted((s1, s2) -> {
                    System.out.println("Sort: " + s1 + " " + s2 + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
                    return s1.compareTo(s2);
                })
                .forEach(s -> {
            System.out.println("foreach: " + s + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        });
    }
}
