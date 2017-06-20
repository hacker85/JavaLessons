package lombok;

import java.util.ArrayList;
import java.util.List;

public class ValLesson {
    public static void main(String[] args) {
        LombokStudent.doIt();

    }
    static class LombokStudent {
        static void doIt() {
            val list = new ArrayList<String>();
            list.add("hello");
            for (val s : list) {
                System.out.println(s.toUpperCase());
            }
        }
    }
    static class Student {
        static void doIt() {
            List<String> list = new ArrayList<>();
            for (String s : list) {
                System.out.println(s.toUpperCase());
            }
        }
    }
}
