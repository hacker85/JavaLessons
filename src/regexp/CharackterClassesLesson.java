package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharackterClassesLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("gr[ae]y");
        Matcher m = p.matcher("gray");
        //Matcher m = p.matcher("grey");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        //examples
        //[0-9][a-z][a-zA-Z][0-9a-fA-F]

        Pattern p2 = Pattern.compile("q[^u]");
        Matcher m2 = p2.matcher("Iraq is a country");
        //Matcher m2 = p2.matcher("Iraq");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        //special chars
        //]\^-
        //[\\x]    [x^]    [^]x]   [-x]   [x-]
        //[\Q[-]\E]
        Pattern p3 = Pattern.compile("[*+]");
        Matcher m3 = p3.matcher("1+1=2");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        //\d - [0-9]       \D-[^d\]
        //\w[a-ZA-Z]    \W-[^w\]
        //\s[ \t]       \S-[^s\]

        //[\s\d]  \s\d
        //[\D\S]

        //repeatCharacters
        //?*+
        Pattern p4 = Pattern.compile("[0-9]+");
        Matcher m4 = p4.matcher("1 + 1 = 2");
        while(m4.find()) {
            System.out.print(m4.start() + " - " + m4.group() + ", ");
        }
        System.out.println("");

//        Pattern p5 = Pattern.compile("([0-9])\\1+");
////        Matcher m5 = p5.matcher("222");
////        Matcher m5 = p5.matcher("876");
//        Matcher m5 = p5.matcher("833337");
//        while(m5.find()) {
//            System.out.print(m5.start() + " - " + m5.group() + ", ");
//        }
//        System.out.println("");

    }
}
