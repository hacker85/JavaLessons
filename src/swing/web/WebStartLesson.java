package swing.web;

import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by husiv on 10/3/16.
 */
public class WebStartLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        ((JButton)jPanel.add(new JButton("submit"))).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOpenService service = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
                    FileContents fileContents = service.openFileDialog(".", new String[]{"txt"});
                    if(fileContents != null) {
                        System.out.println(fileContents);
                    }
                } catch (UnavailableServiceException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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
