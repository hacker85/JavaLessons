package swing.adwanced;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;

/**
 * Created by husiv on 11/7/16.
 */
public class InputStandartFormatLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static JFormattedTextField jFormattedTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
    static JFormattedTextField jFormattedTextField2 = new JFormattedTextField(NumberFormat.getCurrencyInstance());
    static JFormattedTextField jFormattedTextField3 = new JFormattedTextField(NumberFormat.getPercentInstance());
    static JFormattedTextField jFormattedTextField4 = new JFormattedTextField(DateFormat.getDateInstance());
    static JFormattedTextField jFormattedTextField5 = new JFormattedTextField(DateFormat.getTimeInstance());

    public static void main(String[] args) {
        jFrame.add(jPanel);

        jPanel.add(jFormattedTextField);
        jPanel.add(jFormattedTextField2);
        jPanel.add(jFormattedTextField3);
        jPanel.add(jFormattedTextField4);
        jPanel.add(jFormattedTextField5);
        jFormattedTextField.setColumns(10);
        jFormattedTextField2.setColumns(10);
        jFormattedTextField3.setColumns(10);
        jFormattedTextField4.setColumns(10);
        jFormattedTextField5.setColumns(10);
        jFormattedTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setColor1();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setColor1();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        jFrame.revalidate();
    }

    private static void setColor1() {
        jPanel.setBackground(new Color(Integer.parseInt(jFormattedTextField.getText())));
    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 500, 500, 500);
        return jFrame;
    }
}
