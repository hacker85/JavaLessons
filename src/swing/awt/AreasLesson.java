package swing.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class AreasLesson {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;

            Area area = new Area(new Rectangle2D.Double(0,0,100,100));
            //area.add(new Area(new Ellipse2D.Double(50,50, 150, 150)));
            //area.subtract(new Area(new Ellipse2D.Double(50,50, 150, 150)));
            //area.intersect(new Area(new Ellipse2D.Double(50,50, 150, 150)));
            area.exclusiveOr(new Area(new Ellipse2D.Double(50,50, 150, 150)));

            g2.draw(area);
            //g2.fill(area);
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
