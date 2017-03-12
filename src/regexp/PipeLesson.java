package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PipeLesson {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("cat|dog");
        Matcher m = p.matcher("I like my dog!");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("Get|GetValue|Set|SetValue");
//        Pattern p2 = Pattern.compile("Get|GetValue|SetValue|Set");
//        Pattern p2 = Pattern.compile("Get(Value)|Set(Value)");
//        Pattern p2 = Pattern.compile("\\b(Get|GetValue|Set|SetValue)\\b");
//        Pattern p2 = Pattern.compile("\\b(Get(Value)?|Set(Value)?)\\b");
//        Pattern p2 = Pattern.compile("\b(Get|Set)(Value)?\b");
        Matcher m2 = p2.matcher("SetValue");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");
    }
}
