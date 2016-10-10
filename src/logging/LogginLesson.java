package logging;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by husiv on 10/4/16.
 */
public class LogginLesson {
    public static void main(String[] args) throws IOException {
        //-Djava.util.logging.config.file=/home/max/IdeaProjects/JavaLessons/src/logging/log.properties
        //LogManager.getLogManager().readConfiguration();
        //System.out.println(System.getProperty("java.util.logging.config.file"));

        //System.out.println(Logger.getGlobal().getLevel());
        Logger logger = Logger.getGlobal();
        logger.setLevel(Level.INFO);
        logger.info("info message");

        Logger logger2 = Logger.getLogger("logging");
        logger2.warning("warning");
        logger2.fine("fine");
        logger2.setLevel(Level.ALL);
        logger2.throwing("LogginLesson", "main", new Throwable());
        logger2.log(Level.WARNING, "something went wrong", new Throwable());

        Logger currentClassLogger = Logger.getLogger(LogginLesson.class.getName());
        currentClassLogger.setLevel(Level.FINE);
        currentClassLogger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.INFO);
        currentClassLogger.addHandler(handler);
        Handler fileHandler = new FileHandler("%h/java%u.log");
        fileHandler.setFormatter(new MyFormatter());
        currentClassLogger.addHandler(fileHandler);
        currentClassLogger.fine("fine");
        currentClassLogger.info("info");
        currentClassLogger.setFilter(new MyFilter());
        currentClassLogger.info("info");
        currentClassLogger.info("inblafo");

//        Handler streamHandler = new StreamHandler();
//        Handler socketHandler = new SocketHandler();
    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().contains("bla");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + System.getProperty("line.separator");
        }
    }
}
