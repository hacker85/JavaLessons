package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class JComponentLesson {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Font font = new Font("Bitstream Charter", Font.BOLD, 20);
            g2.setFont(font);
            g2.drawString("hello world", 50,50 );
            Point2D p1 = new Point2D.Double(70,70);
            Point2D p2 = new Point2D.Double(170,170);
            Line2D line2D = new Line2D.Double(p1, p2);
            g2.draw(line2D);
            Ellipse2D ellipse2D = new Ellipse2D.Double(70,70,170,170);
            g2.setPaint(Color.red);
            g2.draw(ellipse2D);
            Rectangle2D rectangle2D = new Rectangle2D.Double(70, 70, 170, 170);
            g2.draw(rectangle2D);
        }
    }
    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 300);
        return jFrame;
    }
}
