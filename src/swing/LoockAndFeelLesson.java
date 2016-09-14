package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by husiv on 9/13/16.
 */
public class LoockAndFeelLesson {
    static JFrame jFrame = getFrame();

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /*UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos) {
            System.out.println(info.getName());
            System.out.println(info.getClassName());
        }*/
        JPanel jPanel = new JPanel() {};
        jFrame.add(jPanel);
        JButton button1 = new JButton("metal");
        JButton button2 = new JButton("nimbut");
        JButton button3 = new JButton("motif");
        JButton button4 = new JButton("gtk");
        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
