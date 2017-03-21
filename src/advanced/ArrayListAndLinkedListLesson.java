package advanced;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListAndLinkedListLesson {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        arrayList.add("one");
        arrayList.add("three");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.remove(2);
//        arrayList.remove("three");
//        {1,2,3,4,5,6};
//        {1,2,4,5,6};
//        {3,2,3,5,6} remove(3);
//        {2,3,5,6}
//        {3,2,3,5,6} remove(index 3)
//        {3,2,5,6}
//
//        first -> one -> two -> hree -> last
    }
}
