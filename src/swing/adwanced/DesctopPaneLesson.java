package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;

public class DesctopPaneLesson extends JFrame {
    static JFrame jFrame = new DesctopPaneLesson();
    public static void main(String[] args) throws IOException, PropertyVetoException {
        JTextArea jTextArea = new JTextArea();
        JList<String> jList = new JList<>(new String[]{"one", "two"});

        JDesktopPane jDesktopPane = new JDesktopPane();

        JInternalFrame jInternalFrame = new JInternalFrame("title one", true, true, true, true);
        jInternalFrame.add(jTextArea, BorderLayout.CENTER);
        jInternalFrame.reshape(0, 0, 200, 200);
        jInternalFrame.setVisible(true);
        jInternalFrame.setSelected(true);
        jDesktopPane.add(jInternalFrame);

        JInternalFrame jInternalFrame2 = new JInternalFrame("title two", true, true, true, true);
        jInternalFrame2.add(jList, BorderLayout.CENTER);
        jInternalFrame2.reshape(200, 0, 200, 200);
        jInternalFrame2.setVisible(true);
        jDesktopPane.add(jInternalFrame2);

        jFrame.add(jDesktopPane, BorderLayout.CENTER);
        jFrame.revalidate();
    }

    DesctopPaneLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
    }
}
