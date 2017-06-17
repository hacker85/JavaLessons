package interview;

public class HashCodeImplementationLesson {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        System.out.println(o.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());
        System.out.println(o4.hashCode());
    }
}
