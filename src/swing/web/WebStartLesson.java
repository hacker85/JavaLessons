package swing.web;

import javax.swing.*;

/**
 * Created by husiv on 10/3/16.
 */
public class WebStartLesson {
    static JFrame jFrame = getFrame();
    public static void main(String[] args) throws Exception {
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
