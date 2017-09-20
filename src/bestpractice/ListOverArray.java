package bestpractice;

import java.util.ArrayList;
import java.util.List;

//arrays covariant
//better to find out at compile time
//no array of a generic type, a parameterized type, or a type parameter //new List<E>[] , new List<String>[] , new E[]
//Why generic array creation is illegal
//E , List<E> , and List<String> are non-reifiable types//reifiable types List<?> and Map<?,?>
//Generic varargs
public class ListOverArray {
    public static void main(String[] args) {
        List<?>[] list = new ArrayList<?>[4];
    }

    public static void genericArray(List<String>... list) {
//        List<String>[] stringLists = new ArrayList<String>[1];
//        List<Integer> intList = Arrays.asList(42);
//        Object[] objects = stringLists;
//        objects[0] = intList;
//        String s = stringLists[0].get(0);
    }
}
