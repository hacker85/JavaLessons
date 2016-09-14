package swing;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        JComponent jComponent = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                ((Graphics2D)g).drawString("Coordinates x: ", 50, 50);
            }
        };
        jFrame.add(jComponent);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}