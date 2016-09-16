package swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by husiv on 9/15/16.
 */
public class LayoutLesson {

    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
//        jFrame.add(new Button("one"), BorderLayout.NORTH);
//        jFrame.add(new Button("two"), BorderLayout.WEST);
//        jFrame.add(new Button("three"), BorderLayout.CENTER);
//        jFrame.add(new Button("four"), BorderLayout.EAST);
//        jFrame.add(new Button("five"), BorderLayout.SOUTH);

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(new GridLayout(2,2));
        jPanel.add(new Button("one"));
        jPanel.add(new Button("two"));
        jPanel.add(new Button("three"));
        jPanel.add(new Button("four"));
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
