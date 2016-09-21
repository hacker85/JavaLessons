package swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by husiv on 9/21/16.
 */
public class CustomLayoutManager {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        jPanel.setLayout(new MyLayoutMangager());
        jPanel.add(new JButton("submit"));
        jPanel.add(new JButton("submit"));
        jPanel.add(new JButton("submit"));
    }

    static class MyLayoutMangager implements LayoutManager {
        @Override
        public void addLayoutComponent(String name, Component comp) {}

        @Override
        public void removeLayoutComponent(Component comp) {}

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int n = parent.getComponentCount();
            for (int i = 0; i < n; i++) {
                Component component = parent.getComponent(i);
                switch (i) {
                    case 0: {
                        component.setBounds(0, 0, 100, 40);
                        break;
                    }
                    case 1: {
                        component.setBounds(100, 40, 100, 40);
                        break;
                    }
                    case 2: {
                        component.setBounds(200, 80, 100, 40);
                        break;
                    }
                    default: {
                        component.setBounds(0, 0, 50, 20);
                    }
                }
            }
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
