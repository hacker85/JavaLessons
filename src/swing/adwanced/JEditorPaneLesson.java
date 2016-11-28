package swing.adwanced;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;

/**
 * Created by husiv on 11/28/16.
 */
public class JEditorPaneLesson {
    static JFrame jFrame = getFrame();
    public static void main(String[] args) throws IOException {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setPage("http://help.websiteos.com/websiteos/example_of_a_simple_html_page.htm");

        jEditorPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent event)
            {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try
                    {
                        jEditorPane.setPage(event.getURL());
                    }
                    catch (IOException e)
                    {
                        jEditorPane.setText("Exception: " + e);
                    }
                }
            }
        });

        jPanel.add(jEditorPane);

        jFrame.revalidate();
    }
    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        jFrame.setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
        return jFrame;
    }
}
