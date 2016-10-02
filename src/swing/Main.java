package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JButton jButton = new JButton("show file dialog");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int i = fileChooser.showDialog(jPanel, "save as");
                System.out.println(i);

                File file = fileChooser.getSelectedFile();
                System.out.println(file.getName());
            }
        });
        jPanel.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}