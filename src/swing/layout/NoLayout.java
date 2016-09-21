package swing.layout;

import javax.swing.*;

/**
 * Created by husiv on 9/21/16.
 */
public class NoLayout {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JButton jButton = new JButton("bubmit");
        jPanel.add(jButton);
        jButton.setBounds(50, 50, 150, 30);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
