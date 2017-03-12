package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookaroundLesson {
    public static void main(String[] args) {
        //(?=(regex))
        //loockahead
//        Pattern p = Pattern.compile("q(?=u)");//(?=(regex))  - \\1
        Pattern p = Pattern.compile("q(?!u)");
//        Matcher m = p.matcher("quqa");
        Matcher m = p.matcher("Iraq");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        //loogbehind
        Pattern p2 = Pattern.compile("(?<!a)b");
        Matcher m2 = p2.matcher("cb");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        //work that ends with s
//        Pattern p3 = Pattern.compile("\\b\\w+(?<!s)\\b");
//        Pattern p3 = Pattern.compile("\\b\\w+[^s]\\b");
        Pattern p3 = Pattern.compile("\\b\\w*[^s\\W]\\b");
        Matcher m3 = p3.matcher("John's");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

//        Pattern p4 = Pattern.compile("(?=(\\d+))\\w+\\1");
//        Matcher m4 = p4.matcher("23x123");
////        Pattern p4 = Pattern.compile("(?=(a|b))c");
////        Matcher m4 = p4.matcher("ac");
//        while(m4.find()) {
//            System.out.print(m4.start() + " " + m4.group() + " ");
//        }
//        System.out.println("");
    }
}
