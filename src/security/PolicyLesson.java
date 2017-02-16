package security;

/**
 * Created by max on 2/16/17.
 */
public class PolicyLesson {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "src/MyApp.policy");
        System.setSecurityManager(new SecurityManager());
        System.out.println(System.getProperty("os.name"));
    }
}
