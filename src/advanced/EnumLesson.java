package advanced;

public class EnumLesson {
    public static void main(String[] args) {
    }
}

//final class Level extends Enum
//{
//    public static final Level BEGINNER;
//    public static final Level INTERMEDIATE;
//    public static final Level EXPERT;
//
//    private static final Level $VALUES[];
//    static
//    {
//        BEGINNER = new Level("BEGINNER", 0);
//        INTERMEDIATE = new Level("INTERMEDIATE", 1);
//        EXPERT = new Level("EXPERT", 2);
//        $VALUES = (new Level[] {
//                BEGINNER, INTERMEDIATE, EXPERT
//        });
//    }
//    public static Level[] values()
//    {
//        return (Level[])$VALUES.clone();
//    }
//    public static Level valueOf(String s)
//    {
//        return (Level)Enum.valueOf(Level, s);
//    }
//    private Level(String s, int i)
//    {
//        super(s, i);
//    }
//}

//abstract class Enum<E extends Enum<E>>
//        implements Comparable<E>, Serializable {
//    private final String name;
//    private final int ordinal;
//    protected Enum(String name, int ordinal) {
//        this.name = name;
//        this.ordinal = ordinal;
//    }
//    public String toString() {
//        return name;
//    }
//    public final String name() {
//        return name;
//    }
//}

//class MyEnum<E extends Enum> extends Enum<MyEnum<Enum>> {
//    MyEnum(String s, int i) {
//        super(s,i);
//    }
//}
