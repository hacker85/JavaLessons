package bestpractice;
//value classes
//all fields
//format
//documented
//programmatic access
public class ToStringLesson {
    int i;
    public static void main(String[] args) {
        ToStringLesson stringLesson = new ToStringLesson();
        stringLesson.i = 5;
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(stringLesson);
        }
    }

    @Override
    public String toString() {
        return "ToStringLesson{i=" + i + '}';
    }
}
