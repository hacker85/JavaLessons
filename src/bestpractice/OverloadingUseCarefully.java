package bestpractice;

import java.math.BigInteger;
import java.util.*;

//overloading is counter intuitive //it's confuse programmers
//overriding is static overloading is dynamic
//avoid confusing uses of overloading
//never to export two overloadings with the same number of parameters
//it's safe when number of parameters is different
//it's safe if parameters radically different i.e. ArrayList and int but not Collection
//it's safe if methods do the same
//use constructors carefully //or static factory methods
//second example //adding generics and autoboxing to the language damaged the List interface
//rules 33 pages
public class OverloadingUseCarefully {
    public static String classifySet(Set<?> s) {
        return "Set";
    }
    public static String classifyList(List<?> lst) {
        return "List";
    }
    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }
    public static void main(String[] args) {
//        ObjectOutputStream objectOutputStream;
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
//    public static String classify(Collection<?> c) {
//        return c instanceof Set ? "Set" :
//                c instanceof List ? "List" : "Unknown Collection";
//    }
//    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet<Integer>();
//        List<Integer> list = new ArrayList<Integer>();
//        for (int i = -3; i < 3; i++) {
//            set.add(i);
//            list.add(i);
//        }
//        for (int i = 0; i < 3; i++) {
//            set.remove(i);
//            list.remove(i);
//        }
//        System.out.println(set + " " + list);
//    }
}