package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SplitPaneLesson extends JFrame {
    static JFrame jFrame = new SplitPaneLesson();
    public static void main(String[] args) throws IOException {
        JTextArea jTextArea = new JTextArea();
        JList<String> jList = new JList<>(new String[]{"bla", "bla"});
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jTextArea, jList);
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);
        jFrame.add(jSplitPane);
        jFrame.revalidate();
    }

    SplitPaneLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
    }
}