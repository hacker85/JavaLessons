package swing.dialog;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by husiv on 9/28/16.
 */
public class FileDialogLesson {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        JButton jButton = new JButton("submit");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("."));
                jFileChooser.setSelectedFile(new File("."));
                jFileChooser.setMultiSelectionEnabled(true);
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                //jFileChooser.showOpenDialog(jFrame);
                //jFileChooser.showSaveDialog(jFrame);
                FileFilter fileFilter = new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if(f.getName().endsWith("gif"))
                            return true;
                        else
                            return false;
                    }

                    @Override
                    public String getDescription() {
                        return "Only gif";
                    }
                };
                jFileChooser.setFileFilter(fileFilter);
                int i = jFileChooser.showDialog(jFrame, "Select");
                System.out.println(i);
                File file = jFileChooser.getSelectedFile();
                System.out.println(file.getName());
            }
        });
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
