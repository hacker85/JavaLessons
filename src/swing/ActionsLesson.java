package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by husiv on 9/13/16.
 */
public class ActionsLesson {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel() {};

    public static void main(String[] args) {
        jFrame.add(jPanel);
        JButton button = new JButton(new ColorAction());
        button.setText("submit");
        jPanel.add(button);
    }

    static class ColorAction extends AbstractAction {
        public ColorAction() {
            putValue(Action.SHORT_DESCRIPTION, "change color");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.blue);
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
