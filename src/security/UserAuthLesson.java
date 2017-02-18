package security;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.security.PrivilegedAction;

/**
 * Created by max on 2/16/17.
 */
public class UserAuthLesson {
    public static void main(String[] args) throws LoginException {
        System.setProperty("java.security.policy", "src/MyApp.policy");
        System.setProperty("java.security.auth.login.config", "src/jaas.config");
        System.setSecurityManager(new SecurityManager());
        //System.out.println(System.getProperty("os.name"));

        LoginContext context = new LoginContext("Login1"); // defined in JAAS configuration file
        context.login();
        Subject subject = context.getSubject();
        System.out.println("user is auth");
        Subject.doAsPrivileged(subject, new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                System.out.println(System.getProperty("os.name"));
                return null;
            }
        }, null);
        context.logout();
    }
}
