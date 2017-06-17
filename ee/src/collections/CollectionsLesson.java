package collections;

import java.io.IOException;
import java.util.*;

public class CollectionsLesson {
    public static void main(String[] args) throws IOException {
        Collection<String> collection = new ArrayList();
        List list;
        Set set;
        Queue queue;
        Map map = new HashMap();
        collection.add("Hello");
        collection.add("World");
        System.out.println(collection.size());
        collection.remove("Hello");
        System.out.println(collection.size());
        System.out.println(collection.contains("World"));
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for(String s : collection) {
            System.out.println(s);
        }
        map.put("1", "One");
        map.put("2", "Two");
        System.out.println(map.get("1"));
    }
}
