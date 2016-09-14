package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by husiv on 9/13/16.
 */
public class WindowListenerLesson {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        JPanel jPanel = new JPanel() {
        };
        jFrame.add(jPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                jPanel.setBackground(Color.blue);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                jPanel.setBackground(Color.cyan);
                System.exit(0);
            }
        });
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
