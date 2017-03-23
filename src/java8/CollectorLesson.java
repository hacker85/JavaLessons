package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorLesson {
    public static void main(String[] args) {
        Stream.of("one", "two").collect(toCollection(TreeSet::new));
        Stream.of("one", "two").collect(maxBy(Comparator.comparing(x -> x)));
        Stream.of(1, 2).collect(averagingInt(x -> x));
        Map<Boolean, List<Integer>> map = Stream.of(1, 2, 3, 4).collect(partitioningBy(x -> x >2));
        Map<Integer, List<Integer>> map2 = Stream.of(1, 2, 1, 4).collect(groupingBy(x -> x));
        String result = Stream.of("one", "two", "three").collect(joining(",", "{", "}"));
        System.out.println(result);
        Map<Integer, Long> map3 = Stream.of(1, 2, 1, 4).collect(groupingBy(x -> x, counting()));
        System.out.println(map3.get(1));
        Map<Integer, List<Integer>> collect = Stream.of(1, 2, 1, 4).collect(groupingBy(x -> x, mapping(x -> x, toList())));
    }
}
