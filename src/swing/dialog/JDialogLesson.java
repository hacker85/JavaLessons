package swing.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by husiv on 9/22/16.
 */
public class JDialogLesson {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JButton jButton = new JButton("show dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog myDialog = new MyDialog(jFrame);
                myDialog.setVisible(true);
            }
        });
    }

    static class MyDialog extends JDialog {
        MyDialog(JFrame owner) {
            super(owner, "title", true);
            add(new JLabel("<html><h1><i>hello</i></h1></html>"), BorderLayout.NORTH);
            add(new JButton("test"),BorderLayout.SOUTH);
            setBounds(50, 50, 250, 150);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
