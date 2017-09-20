package bestpractice;

public class EqualsLesson {
    int x;
//    String s;
//
//    public EqualsLesson(String s) {
//        this.s = s;
//    }

    public static void main(String[] args) {
        //symetric
//        System.out.println(new EqualsLesson("").equals(""));
//        System.out.println("".equals(new EqualsLesson("")));
        //transitive
        System.out.println(new EqualsLesson().equals(new EqualsLessonSub()));
        System.out.println(new EqualsLessonSub().equals(new EqualsLesson()));
        EqualsLessonSub equalsLessonSub = new EqualsLessonSub();
        equalsLessonSub.y = 5;
        System.out.println(new EqualsLessonSub().equals(equalsLessonSub));
        System.out.println(new EqualsLesson().equals(equalsLessonSub));
        //consistent
        //non-null
    }

    @Override
    public boolean equals(Object obj) {
        //reflexive x.equals(x) true
//        return new Random().nextBoolean();
        //symmetric x.eqгals(y) = y.equals(x)
//        if (obj instanceof EqualsLesson)
//            return s.equalsIgnoreCase(((EqualsLesson) obj).s);
//        if (obj instanceof String) // One-way interoperability!
//            return s.equalsIgnoreCase((String) obj);
//        return false;
        //transitive x.eqoals(y) and y.equals(z) then z.equals(x)
        if (obj == null || obj.getClass() != getClass()) return false;
//        if (!(obj instanceof EqualsLesson)) return false;
        EqualsLesson el = (EqualsLesson) obj;
        return x == el.x;
        //consistent - don't use environment values
        //non-null x.equals(null) = false
//        if(obj == null) return false;//redundant
//        if (!(obj instanceof EqualsLesson)) return false;
    }
}
class EqualsLessonSub extends EqualsLesson {
    int y;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) return false;
//        if (!(obj instanceof EqualsLesson)) return false;
//        if(!(obj instanceof EqualsLessonSub)) return obj.equals(this);
//        if(!(obj instanceof EqualsLessonSub)) return false;
        return super.equals(obj) && y == ((EqualsLessonSub)obj).y;
    }
}
