package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentsAndFreeSpacingLesson {
    public static void main(String[] args) {
        //#comment
        //(?#year)(19|20)\d\d[-/.](?#month)(0[1-9]|1[012])[- /.](?#day)(0[1-9]|[12][0-9]|3[01])
        //Pattern p = Pattern.compile("a(?#aLetter)", Pattern.COMMENTS);
        Pattern p = Pattern.compile("(?x)a#aLetter");
//        Pattern p = Pattern.compile("a#aLetter", Pattern.COMMENTS);
        Matcher m = p.matcher("a");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("(?x)a b c");
        Matcher m2 = p2.matcher("abc");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        Pattern p3 = Pattern.compile("(?x)\\ d");
        Matcher m3 = p3.matcher("4");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        //(?x) (?> ato mic )  -  ( ?>ato mic)  //bad - (? >atomic)
        //[a b c] no [abc] - last one is three later and space. Same with "\ " - [ ]

    }
}
