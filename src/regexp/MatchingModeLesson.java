package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingModeLesson {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("a", Pattern.CASE_INSENSITIVE);
        Pattern p = Pattern.compile("A#this is commet", Pattern.COMMENTS);
//        Pattern p = Pattern.compile("a", Pattern.MULTILINE);
        Matcher m = p.matcher("A");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        System.out.println("A".matches("(?i)a"));
        "A".matches("(?s)a");//single line
        "A".matches("(?m)a");//multiline
        System.out.println("A".matches("(?x)A#this is comment"));//commetnts
        System.out.println("A".matches("(?ix)a#this is comment"));
        System.out.println("AA".matches("(?i)a(?-i)a"));
        System.out.println("AAA".matches("(?i)a(?-i:A)a"));
    }
}
