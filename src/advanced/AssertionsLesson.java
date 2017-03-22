package advanced;

import java.io.IOException;

public class AssertionsLesson {
    static int number = 10;
    public static void main(String[] args) throws IOException {
        assert false : getI();
        assert false : new IOException();
        assert false : number = 11;
        assert (++number > 5);
    }
    static int getI() {
        return 1;
    }
}
