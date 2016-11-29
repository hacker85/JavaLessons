package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by husiv on 11/28/16.
 */
public class ProgressIndicatorLesson extends JFrame {
    static JFrame jFrame = new ProgressIndicatorLesson();
    public static void main(String[] args) throws IOException {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JProgressBar jProgressBar = new JProgressBar(0, 100);
        jProgressBar.setStringPainted(true);
        //jProgressBar.setIndeterminate(true);

        jPanel.add(jProgressBar);

        for (int i = 0; i <= 100; i += 10) {
            jProgressBar.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    ProgressIndicatorLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
    }
}
