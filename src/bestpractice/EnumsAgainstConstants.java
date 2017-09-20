package bestpractice;

//pass apple to method that works with oranges
//can compare apples with oranges
//no namespace
//no string representation
//cant iterate
//String constants - performance issues //need to be compare to hard-coded constants
public class EnumsAgainstConstants {
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    public static void main(String[] args) {
        int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;
    }
}

//final, singleton, implements Comparable and Serializable, we can add methods and fields
//enum is immutable - all fields should be final
enum Apple {
    FUJI, PIPPIN, GRANNY_SMITH;
}
enum Orange { NAVEL, TEMPLE, BLOOD }
