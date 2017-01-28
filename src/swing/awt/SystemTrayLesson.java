package swing.awt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class SystemTrayLesson {
    public static void main(String[] args) throws IOException, URISyntaxException, AWTException {
        if(SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = new ImageIcon("/home/max/IdeaProjects/JavaLessons/icon.jpg", "descr").getImage();
            PopupMenu menu = new PopupMenu();
            menu.add(new MenuItem("one"));
            menu.add(new MenuItem("two"));
            tray.add(new TrayIcon(image, "description", menu));
        }
    }
}
