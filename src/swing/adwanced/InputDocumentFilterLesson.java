package swing.adwanced;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by husiv on 11/7/16.
 */
public class InputDocumentFilterLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static JFormattedTextField jFormattedTextField = new JFormattedTextField(new InternationalFormatter(NumberFormat.getIntegerInstance()) {
        protected DocumentFilter getDocumentFilter() {
            return new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                    StringBuilder stringBuilder = new StringBuilder(string);
                    for (int i = stringBuilder.length() - 1; i >= 0; i--) {
                        if(!Character.isDigit(stringBuilder.codePointAt(i))) {
                            stringBuilder.deleteCharAt(i);
                            i--;
                        }
                    }
                    super.insertString(fb, offset, stringBuilder.toString(), attr);
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    StringBuilder stringBuilder = new StringBuilder(text);
                    for (int i = stringBuilder.length() - 1; i >= 0; i--) {
                        if(!Character.isDigit(stringBuilder.codePointAt(i))) {
                            stringBuilder.deleteCharAt(i);
                            i--;
                        }
                    }
                    super.replace(fb, offset, length, stringBuilder.toString(), attrs);
                }
            };
        }
    });
    public static void main(String[] args) {
        jFrame.add(jPanel);

        jPanel.add(jFormattedTextField);
        jFormattedTextField.setColumns(10);
        jFormattedTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setColor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setColor();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        jFrame.revalidate();
    }

    private static void setColor() {
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
