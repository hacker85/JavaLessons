package swing.adwanced;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by husiv on 10/13/16.
 */
public class JListLesson {
    static JFrame jFrame = getFrame();
    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        String[] values = new String[]{"one","two","three", "four"};
        JList<String> jList = new JList<>(values);
        jList.setVisibleRowCount(2);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JOptionPane.showMessageDialog(jPanel, values[e.getLastIndex()]);
                JList list = (JList) e.getSource();
                for(String s :jList.getSelectedValuesList()) {
                    System.out.println(s);
                }
            }
        });
        jPanel.add(jList);
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
