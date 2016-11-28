package swing.adwanced;

import javax.swing.*;
import java.awt.*;

/**
 * Created by husiv on 11/23/16.
 */
public class JSpinnerLesson {
    static JFrame jFrame = getFrame();
    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        //JSpinner jSpinner = new JSpinner(new SpinnerNumberModel(5,0,10,0.5));
        //String[] strings = {"one", "two", "three"};
        //JSpinner jSpinner = new JSpinner(new SpinnerListModel(strings));
        JSpinner jSpinner = new JSpinner(new SpinnerDateModel());
//        String pattern = ((SimpleDateFormat) DateFormat.getDateInstance()).toPattern();
//        jSpinner.setEditor(new JSpinner.DateEditor(jSpinner, pattern));
        jPanel.add(jSpinner);

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
