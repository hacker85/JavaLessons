package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TabbedPaneLesson extends JFrame {
    static JFrame jFrame = new TabbedPaneLesson();
    public static void main(String[] args) throws IOException {
        JTextArea jTextArea = new JTextArea();
        JList<String> jList = new JList<>(new String[]{"one", "two"});
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("textArea", jTextArea);
        jTabbedPane.addTab("list", jList);

        int textAreaIndex = jTabbedPane.indexOfTab("textArea");
        int listIndex = jTabbedPane.indexOfTab("list");
        jTabbedPane.setMnemonicAt(textAreaIndex, KeyEvent.VK_0);
        jTabbedPane.setMnemonicAt(listIndex, KeyEvent.VK_1);

        jFrame.add(jTabbedPane);
        jFrame.revalidate();
    }

    TabbedPaneLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
    }
}
