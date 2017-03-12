package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotLesson {
    public static void main(String[] args) {
        //. - [^\n] unix - [^\r\n] windows

        //mm/dd/yy
        Pattern p = Pattern.compile("\\d\\d.\\d\\d.\\d\\d");
        //Pattern p = Pattern.compile("\\d\\d[- /.]\\d\\d[- /.]\\d\\d");
        Matcher m = p.matcher("02/12/03");
        //Matcher m = p.matcher("02512703");
        //Matcher m = p.matcher("grey");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

        Pattern p2 = Pattern.compile("\".*\"");
        //Pattern p2 = Pattern.compile("\"[^\"\r\n]*\"");
        Matcher m2 = p2.matcher("Put a \"string\" between double quotes");
       // Matcher m2 = p2.matcher("Houston, we have a problem with \"string one\" and \"string two\". Please respond.");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
    }
}
