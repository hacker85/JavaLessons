package debugging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by husiv on 10/10/16.
 */
public class DebuggingLesson {
    public static void main(String[] args) throws IOException {
        //1
        Logger.getGlobal().info("info");
        System.out.println("print");
        //2
        //psvm
        //4
        Random random = new Random() {
            public double nextDouble() {
                double dbl = super.nextDouble();
                Logger.getGlobal().info(dbl + "");
                return dbl;
            }
        };
        //5
        try{

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        secondMethod();
        //6
        thredMethod();
        //7
        //java MyProgram > errors.txt
        //8
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //save to file
            }
        });
        //9
        //-verbose
        //10
        //-Xlint
        new Date().getDate();
        //http://www.sonarqube.org/
        //11
        //java console
        //12
        //jmap - dump:format=b,file=dump.txt processId
        //jhat dumpfile.txt
        //13
        //-Xprof
    }

    static void secondMethod() {
        Thread.dumpStack();
    }

    static void thredMethod() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File("test.txt")));
        new Throwable("mtExeption").printStackTrace(writer);
        writer.flush();
        writer.close();
    }
}
