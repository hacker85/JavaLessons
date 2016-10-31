package swing.adwanced;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by husiv on 10/24/16.
 */
public class TableLesson {
    static JFrame jForm = getFrame();
    public static void main(String[] args) {
        Object[][] cells = {{"Max",20}, {"Mike", 22}, {"den", 25}};
        String[] columnNames = {"Name", "age"};
        JTable jTable = new JTable(cells, columnNames);
        JPanel jPanel = new JPanel();

        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable.setAutoCreateRowSorter(true);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Class<?> columnClass =  jTable.getColumnClass(jTable.getSelectedColumn());
                System.out.println(columnClass.getName());
            }
        });

        jPanel.add(new JScrollPane(jTable));
        jForm.add(jPanel);
        jPanel.revalidate();
        jForm.pack();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(700, 300, 500, 250);
        jFrame.setVisible(true);
        return jFrame;
    }
}
