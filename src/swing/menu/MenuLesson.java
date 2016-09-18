package swing.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by husiv on 9/16/16.
 */
public class MenuLesson {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();

        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        fileMenu.add(new JMenuItem("Open", 'O'));
        fileMenu.add(new JMenuItem("Open As")).setEnabled(false);
        fileMenu.add(new JPopupMenu.Separator());
        fileMenu.add(new JMenuItem("Close"));

        editMenu.add(new JMenuItem("Cut"));
        editMenu.add("copy");

        JMenu options = new JMenu("Options");
        options.add(new JMenuItem("one"));
        options.add(new JMenuItem("two"));
        editMenu.add(options);

        editMenu.add(new JCheckBoxMenuItem("check box"));

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem jRadioButtonMenuItem1 = new JRadioButtonMenuItem("one");
        JRadioButtonMenuItem jRadioButtonMenuItem2 = new JRadioButtonMenuItem("two");
        buttonGroup.add(jRadioButtonMenuItem1);
        buttonGroup.add(jRadioButtonMenuItem2);
        editMenu.add(jRadioButtonMenuItem1);
        editMenu.add(jRadioButtonMenuItem2);

        JMenuItem exit = fileMenu.add(new JMenuItem("exit"));
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jFrame.setJMenuBar(jMenuBar);
        jFrame.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
