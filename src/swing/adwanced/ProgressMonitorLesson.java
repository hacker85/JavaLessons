package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProgressMonitorLesson extends JFrame {

    static JFrame jFrame = new ProgressMonitorLesson();

    static ProgressMonitor progressMonitor = new ProgressMonitor(null, "Message", "Initializing . . .", 0, 100);

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            if (progressMonitor.isCanceled()) {
                progressMonitor.close();
                System.exit(1);
            }
            progressMonitor.setProgress(i);
            progressMonitor.setNote("Operation is " + i + "% complete");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    ProgressMonitorLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);


    }
}