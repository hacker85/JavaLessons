package security;

import java.applet.Applet;

public class VerifierTest extends Applet {
    public static void main(String[] args) {
        System.out.println("1 + 2 == " + fun());
    }

    public static int fun() {
        int m;
        int n;
        m = 1;
        n = 2;
// use hex editor to change to "m = 2" in class file
        int r = m + n;
        return r;
    }
}