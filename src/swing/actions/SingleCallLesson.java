package swing.actions;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * Created by husiv on 9/13/16.
 */
public class SingleCallLesson {

    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        JPanel jPanel = new JPanel() {
        };
        jFrame.add(jPanel);
        JButton button = new JButton("submit");
        jPanel.add(button);
        /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setTitle(((JButton)e.getSource()).getText());
                //jPanel.setBackground(Color.blue);
            }
        });*/
        button.addActionListener(EventHandler.create(ActionListener.class, jFrame, "setTitle", "source.text"));
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
