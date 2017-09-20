package bestpractice;

//code reuse
//make api familiar
//your API easier to learn
//easier to read
//smaller memory amount
//java api covers almost all
//IllegalArgumentException //IllegalStateException //NullPointerException//IndexOutOfBoundsException //ConcurrentModificationException
//UnsupportedOperationException
public class UseStandardExceptions {
    public static void main(String[] args) {
        exceptionMethod(5);
    }
    public static void exceptionMethod(int i) {
        if(i < 0)
            throw new IllegalArgumentException("i < 0");
    }
}
