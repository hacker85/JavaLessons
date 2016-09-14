package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by husiv on 9/13/16.
 */
public class MouseLesson {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) {
        JPanel jPanel = new JPanel(){};
        JComponent jComponent = new MyPanel();
        jFrame.add(jPanel);
        //jFrame.add(jComponent);
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                jPanel.setBackground(Color.blue);
            }
        });
//        jFrame.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//                MyPanel.xCoord = e.getX();
//                MyPanel.yCoord = e.getY();
//                jComponent.repaint();
//            }
//        });
    }

    static class MyPanel extends JComponent {
            public static int xCoord;
            public static int yCoord;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ((Graphics2D)g).drawString("Coordinates x: " + xCoord + " Y: " + yCoord, 50, 50);
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
