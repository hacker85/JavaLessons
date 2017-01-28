package swing.awt;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class RunDesctoopAppsLesson {
    public static void main(String[] args) throws IOException {
        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            for (Desktop.Action action : Desktop.Action.values()) {
                System.out.println(action);
            }
            if(desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File("/home/max/IdeaProjects/JavaLessons/smile.jpg"));
            }
            if(desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(URI.create("https://google.com"));
            }
        }
    }
}
