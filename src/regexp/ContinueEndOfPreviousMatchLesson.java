package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContinueEndOfPreviousMatchLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\G\\w");
        Matcher m = p.matcher("text string");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");
    }
}
