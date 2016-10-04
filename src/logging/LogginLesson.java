package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by husiv on 10/4/16.
 */
public class LogginLesson {
    public static void main(String[] args) {
        System.out.println(Logger.getGlobal().getLevel());
        Logger.getGlobal().setLevel(Level.INFO);
        Logger.getGlobal().info("info message");
    }
}
