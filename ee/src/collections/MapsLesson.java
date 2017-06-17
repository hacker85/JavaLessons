package collections;

import java.util.*;

public class MapsLesson {
    public static void main(String[] args) {
        Map<String,String> hashMap = new HashMap<>();
        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        Map<String,String> treeMap = new TreeMap<>();
        Map<String,String> hashTable = new Hashtable<>();
        Map<String,String> syncMap = Collections.synchronizedMap(new HashMap<>());
        //how store elements
        //initial value and how increment
        //max capacity
        //load factor
        //java hashMap same bucket different hashCodes
        //HashMap Performance Improvements in Java 8
        //can hashMap become smaller
        //navigable map
        //backed map
        //where compareTo
        //memory treeMap and HashMap
        //syncMap vs hashTable
        NavigableMap<String, Integer> navigableMap = new TreeMap<>();
        navigableMap.put("a", 1);
        navigableMap.put("d", 4);
        navigableMap.put("c", 3);
        System.out.println(navigableMap.tailMap("b"));
        System.out.println(navigableMap.headMap("b"));
        System.out.println(navigableMap.tailMap("b").lastKey());
        System.out.println(navigableMap.headMap("b").firstKey());

        System.out.println(navigableMap.subMap("b", "d"));
    }
    static class Student {
        int id;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return id == student.id;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
