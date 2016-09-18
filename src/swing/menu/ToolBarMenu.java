package swing.menu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by max on 9/18/16.
 */
public class ToolBarMenu {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) throws Exception {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JToolBar jToolBar = new JToolBar("title");
        JButton one = new JButton("one");
        one.setToolTipText("first");
        jToolBar.add(one);
        jToolBar.add(new Button("two"));
        jToolBar.addSeparator();
        jToolBar.add(new Button("three"));
        jPanel.add(jToolBar);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
