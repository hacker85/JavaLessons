package bestpractice;

import java.util.ArrayList;
import java.util.List;

//no constructor
//never make the client do anything the library can do for the client
//final fields problem
//creation time
//use constructor or factory analog //can use interface
public class CloneableLesson implements Cloneable {
    int i;
    private Object[] elements;
    public CloneableLesson() {
        System.out.println("this is constructor");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableLesson cloneableLesson = new CloneableLesson();
        CloneableLesson cloneableLesson2 = cloneableLesson.clone();
        System.out.println(cloneableLesson != cloneableLesson2);
        System.out.println(cloneableLesson.getClass() == cloneableLesson2.getClass());
        System.out.println(cloneableLesson.equals(cloneableLesson2.getClass()));
        //example
        List list = new ArrayList();
        List list2 = new ArrayList(list);
    }
    public static CloneableLesson makeCopy(CloneableLesson cloneableLesson) {
        //make copy;
        return cloneableLesson;
    }
    @Override
    protected CloneableLesson clone() {
        CloneableLesson result = null;
        try {
            result = (CloneableLesson) super.clone();
            result.elements = elements.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
