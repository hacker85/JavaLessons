package swing;

import javax.swing.*;

/**
 * Created by husiv on 9/15/16.
 */
public class TextInputLesson {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(new JLabel("<html><b>this is label</b></html>"));
        jPanel.add(new JTextField("text", 10));
        jPanel.add(new JPasswordField(10));
        JTextArea jTextArea = new JTextArea(8, 30);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel.add(jScrollPane);
        jPanel.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
