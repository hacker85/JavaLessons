package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by husiv on 11/17/16.
 */
public class InputVerifyerLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static JFormattedTextField jFormattedTextField = new JFormattedTextField();

    public static void main(String[] args) {
        jFrame.add(jPanel);

        jFormattedTextField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                StringBuilder stringBuilder = new StringBuilder(((JFormattedTextField)input).getText().toString());
                for (int i = stringBuilder.length() - 1; i >= 0; i--) {
                    if(!Character.isDigit(stringBuilder.codePointAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        });
        jFormattedTextField.setColumns(10);
        jPanel.add(jFormattedTextField);

        JButton jButton = new JButton("submit");
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.setBackground(new Color(Integer.parseInt(jFormattedTextField.getText())));
            }
        });

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
