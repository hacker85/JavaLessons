package debugging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

/**
 * Created by husiv on 10/11/16.
 */
public class RobotLesson {

    static JFrame jFrame = getFrame();

    public static void main(String[] args) throws AWTException {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton jButton = new JButton("add");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setTitle(jFrame.getTitle() + "1");
            }
        });
        JButton jButton2 = new JButton("click add");
        jPanel.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice device = graphicsEnvironment.getDefaultScreenDevice();
                Robot robot = null;
                try {
                    robot = new Robot(device);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
                robot.mouseMove(750 + jButton.getX() + 20, 250 + jButton.getY() + 30);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);

                //robot.keyPress(KeyEvent.VK_D);
            }
        });
    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        return jFrame;
    }
}
