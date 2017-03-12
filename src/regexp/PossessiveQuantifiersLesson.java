package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifiersLesson {
    public static void main(String[] args) {
        //*+  ++ ?+
        Pattern p = Pattern.compile("\"[^\"]*+\"");
        Matcher m = p.matcher("\"abc\"");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("\".*+\"");
        Matcher m2 = p2.matcher("\"abc\"x");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        //atomic group
        //X*+ - (>X*)
//        Pattern p3 = Pattern.compile("(?:a|b)*+b");
//        Pattern p3 = Pattern.compile("(?>(?:a|b)*)b");
        Pattern p3 = Pattern.compile("(?>a|b)*b");//not
        Matcher m3 = p3.matcher("b");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");
    }
}
