package swing.awt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class PaintLesson {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            //g2.setPaint(Color.red);
            g2.setPaint(new GradientPaint(new Point(0, 0), Color.red, new Point(200,100), Color.yellow));
            try {
                g2.setPaint(new TexturePaint(ImageIO.read(new File("")), new Rectangle2D.Double(0, 0, 200, 100)));
            } catch (IOException e) {}

            Ellipse2D ellipse = new Ellipse2D.Double(0, 0, 200, 100);
            g2.fill(ellipse);
        }
    }
    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 550, 300);
        return jFrame;
    }
}
