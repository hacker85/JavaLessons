package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarPlusRepetitioinLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("<[A-Za-z][A-Za-z0-9]*");//+ *
        Matcher m = p.matcher("<h1>");
//        Matcher m = p.matcher("<a>");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

//        Pattern p2 = Pattern.compile("\\b[1-9][0-9]{3}\\b"); // {0,} - *
        Pattern p2 = Pattern.compile("\\b[1-9][0-9]{2,4}\\b"); // {1,} - +
//        Matcher m2 = p2.matcher("1000 9999");
        Matcher m2 = p2.matcher("100 99999");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        Pattern p3 = Pattern.compile("<.+>");//greedy ? - lazy reluctant
        //Pattern p3 = Pattern.compile("<.+?>");
        //Pattern p3 = Pattern.compile("<[^>]+>");
        Matcher m3 = p3.matcher("This is a <EM>first</EM> test");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        Pattern p4 = Pattern.compile("\\Q*\\d+*\\E+");
//        Pattern p4 = Pattern.compile("\\Q*\\d+\\E*+");
//        Pattern p4 = Pattern.compile("(?:\\Q*\\d+*\\E)+");
        Matcher m4 = p4.matcher("*\\d+**\\d+*");
        while(m4.find()) {
            System.out.print(m4.start() + " " + m4.group() + " ");
        }
        System.out.println("");
    }
}
