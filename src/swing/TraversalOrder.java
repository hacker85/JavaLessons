package swing;

import javax.swing.*;

/**
 * Created by husiv on 9/21/16.
 */
public class TraversalOrder {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        jPanel.add(new JButton("submit1"));
        jPanel.add(new JButton("submit2")).setFocusable(false);
        jPanel.add(new JButton("submit3"));
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
