package swing.dialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by husiv on 9/22/16.
 */
public class DialogBoxLesson {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JButton jButton = new JButton("show dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel, "this is message", "title", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showConfirmDialog(jPanel, new JButton("bla"));
                JOptionPane.showOptionDialog(jPanel, "this is option dialog", "title3", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"one", "two"}, "two");
                JOptionPane.showInputDialog(jPanel, "this is input dialog");
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
