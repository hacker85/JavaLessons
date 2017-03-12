package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PosixCharacterClassesLesson {
    public static void main(String[] args) {
        //[:digit:]
        //[x-z[:digit:]]
        Pattern p = Pattern.compile("[^x-z\\p{Digit}]");
//        Pattern p = Pattern.compile("[x-z^\\p{Digit}]");
        Matcher m = p.matcher("5");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");
    }
}
