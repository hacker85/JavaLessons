package swing.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ShapesLesson {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            g.drawLine(0,0, 50, 50);
            Graphics2D g2 = (Graphics2D)g;

            Point2D point = new Point2D.Double(50, 0);
            Point2D point2 = new Point2D.Double(100, 50);

            Line2D line = new Line2D.Double(point, point2);
            g2.draw(line);

            Rectangle2D rectangle = new Rectangle2D.Double(100, 0, 100, 50);
            g2.fill(rectangle);

            RoundRectangle2D roundRectangle = new RoundRectangle2D.Double(200, 0, 100, 50, 20, 20);
            g2.draw(roundRectangle);

            Ellipse2D ellipse = new Ellipse2D.Double(300, 0, 100, 50);
            g2.draw(ellipse);


            QuadCurve2D quadCurve = new QuadCurve2D.Double(400, 0, 425, 100, 450, 0);
            g2.draw(quadCurve);

            CubicCurve2D cubicCurve = new CubicCurve2D.Double(450, 50, 475, 150, 525, -50, 550, 50);
            g2.draw(cubicCurve);

            Arc2D arc = new Arc2D.Double(0, 100, 100, 100, 0, 90, Arc2D.PIE);
            g2.draw(arc);

            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(100,100);
            generalPath.lineTo(200,100);
            generalPath.quadTo(250, 200, 300, 100);
            generalPath.curveTo(325, 200, 375, 0, 400, 100);
            generalPath.closePath();
            g2.draw(generalPath);
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
