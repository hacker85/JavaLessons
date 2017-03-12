package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEndStringAnchorsLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^a");
//        Pattern p = Pattern.compile("^b");
//        Pattern p = Pattern.compile("c$");
//        Pattern p = Pattern.compile("b$");
        Matcher m = p.matcher("abc");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("\\d+");
        //Pattern p2 = Pattern.compile("^\\d+$");
        Matcher m2 = p2.matcher("ab4c");
        if(m2.find()) {
            System.out.println("it's a number");;
        }
        System.out.println("");

        //^\s+
        //\s+$

        Pattern p3 = Pattern.compile("ne$", Pattern.MULTILINE);
//        Pattern p3 = Pattern.compile("\\Ane\\Z", Pattern.MULTILINE);
        //Pattern p3 = Pattern.compile("ne\\z", Pattern.MULTILINE);
        Matcher m3 = p3.matcher("first line\nsecond line");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        "749\\n486\\n4".matches("^4$");

        Pattern p4 = Pattern.compile("^\\d*$");
        Matcher m4 = p4.matcher("");
        if(m4.find()) {
            System.out.println(m4.start());
            System.out.println("".charAt(m4.start()));
        }
        System.out.println("");
    }
}
