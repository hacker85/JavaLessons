package security;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, UnsupportedEncodingException, MalformedURLException, ClassNotFoundException {
        System.setProperty("java.security.policy", "src/MyApp.policy");
        System.setSecurityManager(new SecurityManager());
        printString("hello");
        printString("php");
    }

    static void printString(String s) {
        MyPermission myPermission = new MyPermission("use");
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(myPermission);
        }
        System.out.println(s);
    }
}