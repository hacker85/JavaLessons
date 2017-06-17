package interview;

import java.util.*;

public class ImmutableCollectionsLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        List<String> list2 = Collections.unmodifiableList(list);
        list.add("three");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        Set<String> set = Collections.unmodifiableSet(new HashSet<>());
        Map<String,String> map = Collections.unmodifiableMap(new HashMap());
    }
}
