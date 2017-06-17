package collections;

import java.util.*;

public class ListsLesson {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        List vector = new Vector();
        List stack = new Stack();
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("B");
        //modify when iterate
//        for(String s : arrayList) {
//            System.out.println(s);
//            arrayList.add("Z");
//        }
        //sort
//        for(String s : arrayList) {
//            System.out.println(s);
//        }
//        Collections.sort(arrayList);
//        for(String s : arrayList) {
//            System.out.println(s);
//        }
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(3));
//        students.add(new Student(1));
//        students.add(new Student(2));
//        Collections.sort(students);
//        for(Student s : students) {
//            System.out.println(s.id);
//        }
        //binary search
//        System.out.println(arrayList.get(Collections.binarySearch(arrayList, "B")));
//        Collections.sort(arrayList);
//        System.out.println(arrayList.get(Collections.binarySearch(arrayList, "B")));
        //to array and back
//        String[] strings = new String[arrayList.size()];
//        strings = arrayList.toArray(strings);
//        List<String> list = Arrays.asList(strings);
        //list equals
//        System.out.println(arrayList.equals(list));

//        List list = new ArrayList();
//        List list2 = new ArrayList();
//        list.add(list2);
//        list2.add(list);
//        System.out.println(list.equals(list2));
        //toString
//        System.out.println(arrayList.toString());
        //vector vs sync
        //vector is sync and sync is wrapper it's better if we have list and want to wrap it
        //vector add elements faster cause it twice its size, sync multiply on 1.5
        //sync iterates faster cause vector locks next, sync is bad cause client need to sync, then speed the same
        //vector has old methods
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>(2_000_000));
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        Vector<Integer> vector2 = new Vector<>(2_000_000);
//        List<Integer> vector2 = new Vector<>();
//        System.out.println(new Date());
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10_000_000; i++) {
//            list.add(i);
//        }
//        vector2.add(0, 5);
//        for(Integer i : vector2) {
//            int k = i;
//        }
//        System.out.println(new Date());
//        long finish = System.currentTimeMillis();
//        System.out.println("time taken: " + (finish - start));
        //add more then size
//        List<Long> longs = new LinkedList();
//        for(long i = 0; i < 2_000_000_000; i++) {
//            longs.add(i);
//        }

    }
    static class Student implements Comparable {
        int id;
        String name;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            return id - ((Student)o).id;
        }
    }
}
