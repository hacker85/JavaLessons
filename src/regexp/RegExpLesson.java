package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by max on 3/4/17.
 */
public class RegExpLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("abaaaba");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("aba");
        Matcher m2 = p2.matcher("abababa");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        //Pattern p3 = Pattern.compile("\\d");
        Pattern p3 = Pattern.compile("\\d+");
        Matcher m3 = p3.matcher("a12c3e456f");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        Pattern p4 = Pattern.compile("\\w");
        Matcher m4 = p4.matcher("a 1 56 _Z");
        while(m4.find()) {
            System.out.print(m4.start() + " " + m4.group() + " ");
        }
        System.out.println("");

        Pattern p5 = Pattern.compile("[a-c]");
        Matcher m5 = p5.matcher("abc");
        while(m5.find()) {
            System.out.print(m5.start() + " " + m5.group() + " ");
        }
        System.out.println("");

        Pattern p6 = Pattern.compile("proj1([^,])*");
        Matcher m6 = p6.matcher("proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java");
        while(m6.find()) {
            System.out.print(m6.start() + " " + m6.group() + " ");
        }
        System.out.println("");

        Pattern p7 = Pattern.compile("\\d\\d\\d([-\\s])?\\d\\d\\d\\d");
        Matcher m7 = p7.matcher("123 4567");
        while(m7.find()) {
            System.out.print(m7.start() + " " + m7.group() + " ");
        }
        System.out.println("");

        Pattern p8 = Pattern.compile("a.c");
        Matcher m8 = p8.matcher("ac abc a c");
        while(m8.find()) {
            System.out.print(m8.start() + " " + m8.group() + " ");
        }
        System.out.println("");

        //greedy
        Pattern p9 = Pattern.compile(".*xx");
        Matcher m9 = p9.matcher("yyxxxyxx");
        while(m9.find()) {
            System.out.print(m9.start() + " " + m9.group() + " ");
        }
        System.out.println("");

        //reluctant
        Pattern p10 = Pattern.compile(".*?xx");
        Matcher m10 = p10.matcher("yyxxxyxx");
        while(m10.find()) {
            System.out.print(m10.start() + " " + m10.group() + " ");
        }
        System.out.println("");

        //possessive
        Pattern p11 = Pattern.compile(".*+xx");
        Matcher m11 = p11.matcher("yyxxxyxx");
        while(m11.find()) {
            System.out.print(m11.start() + " " + m11.group() + " ");
        }
    }
}
