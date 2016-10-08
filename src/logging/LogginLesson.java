package logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by husiv on 10/4/16.
 */
public class LogginLesson {
    public static void main(String[] args) throws IOException {
        //-Djava.util.logging.config.file=/home/max/IdeaProjects/JavaLessons/src/logging/log.properties
        LogManager.getLogManager().readConfiguration();
        System.out.println(System.getProperty("java.util.logging.config.file"));

        System.out.println(Logger.getGlobal().getLevel());
        Logger.getGlobal().setLevel(Level.INFO);
        Logger.getGlobal().info("info message");

        Logger logger = Logger.getLogger("com.logging");
        logger.warning("warning");
        logger.fine("fine");
        logger.throwing("LogginLesson", "main", new Throwable());
        logger.log(Level.ALL, "something went wrong", new Throwable());

        Logger currentClass = Logger.getLogger(LogginLesson.class.getName());
    }
}
