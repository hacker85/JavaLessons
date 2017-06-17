package interview;

public class CloneLesson implements Cloneable {
    int i;
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneLesson cloneLesson = new CloneLesson();
        cloneLesson.i = 5;
        CloneLesson clone = (CloneLesson) cloneLesson.clone();
        System.out.println(clone.i);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
