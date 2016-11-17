package swing.adwanced;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * Created by husiv on 11/17/16.
 */
public class InputCustomMaskFormatterLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static JFormattedTextField jFormattedTextField;

    static {
        try {
            jFormattedTextField = new JFormattedTextField(new MaskFormatter("###-##-??"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jFrame.add(jPanel);

        jPanel.add(jFormattedTextField);
        jFormattedTextField.setColumns(10);
        jFrame.revalidate();
    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 500, 500, 500);
        return jFrame;
    }
}
