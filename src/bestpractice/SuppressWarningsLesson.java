package bestpractice;

import java.util.HashSet;
import java.util.Set;

//eliminate warnings
//use smallest scope possible
//always comment
public class SuppressWarningsLesson {
    public static void main(String[] args) {
        run();
    }public static Set<String> run() {
        //some code
        @SuppressWarnings("unchecked") //value return from old method
        Set<String> exaltation = new HashSet();
        return exaltation;
    }
}
