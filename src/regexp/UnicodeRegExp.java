package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeRegExp {
    public static void main(String[] args) {
        System.out.println("\u0061\u0300");//\uFFFF
        System.out.println("\u00E0");

//        Pattern p = Pattern.compile("à");
        Pattern p = Pattern.compile("\u00E0");
//        Pattern p = Pattern.compile("\\u00E0")
//        Pattern p = Pattern.compile("\\x{00E0}");
//        Matcher m = p.matcher("à");
        Matcher m = p.matcher("à");
        while(m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
        System.out.println("");

//\p{}   L-unicode letter   M-ascii letter and symbol of new line  Z-any space
        //S - symbol(dollar etc.)   N-number    P-punctuation     C-other, invisible character, unused code point
//        Pattern p2 = Pattern.compile("\\p{L}");
//        Pattern p2 = Pattern.compile("\\p{M}");
//        Pattern p2 = Pattern.compile("\\p{Z}");
        Pattern p2 = Pattern.compile("\\pZ");
//        Pattern p2 = Pattern.compile("(\\p{L}\\p{M})*");
        Matcher m2 = p2.matcher("à 1");
        while(m2.find()) {
            System.out.print(m2.start() + " " + m2.group() + " ");
        }
        System.out.println("");

        //\p{Tibetan}
        //\p{InCurrency}
        Pattern p3 = Pattern.compile("\\p{Digit}");
        Matcher m3 = p3.matcher("5XI");
        while(m3.find()) {
            System.out.print(m3.start() + " " + m3.group() + " ");
        }
        System.out.println("");

        Pattern p4 = Pattern.compile("à", Pattern.CANON_EQ);
        Matcher m4 = p4.matcher("à");
        while(m4.find()) {
            System.out.print(m4.start() + " " + m4.group() + " ");
        }
        System.out.println("");
    }
}
