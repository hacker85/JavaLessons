package bestpractice;

//don't ignore exceptions
//capture all information
public class ExceptionsLesson {
    public static void main(String[] args) {
//        try {
//            System.out.println("hello");
//        } catch (Exception e) {
//        }
        try {
            System.out.println("hello");
        } catch (Exception e) {
            System.out.println("args: " + args + " letngh: " + args.length);
        }
    }
}
