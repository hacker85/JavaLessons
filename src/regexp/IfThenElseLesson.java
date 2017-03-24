package regexp;

public class IfThenElseLesson {
    public static void main(String[] args) {
        //need jRegex
        //(?ifthen|else)
        //(?ifthen)
        //(?(?=regex)then|else)
        ///(?(?=condition)(then1|then2|then3)|(else1|else2|else3))
        //System.out.println("bd".matches("(a)?b(?(1)c|d)"));
//        Pattern p = new Pattern("(a)?b(?(1)c|d)");//^
////        Pattern p = new Pattern("(?<test>a)?b(?(\\k<test>)c|d)");//not work
////        Matcher m=p.matcher("bd");
////        Matcher m=p.matcher("abc");
////        Matcher m=p.matcher("bc");
//        Matcher m=p.matcher("abd");
//        while(m.find()) {
//            System.out.print(m.start() + " " + m + " ");
//        }
//        System.out.println("");
    }
}
