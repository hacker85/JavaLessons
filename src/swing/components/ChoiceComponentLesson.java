package swing.components;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Created by husiv on 9/16/16.
 */
public class ChoiceComponentLesson {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(new JCheckBox("Bold"));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton button1 = new JRadioButton("one", true);
        JRadioButton button2 = new JRadioButton("two", true);
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        jPanel.add(button1);
        jPanel.add(button2);
        Border border = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(border, "title");

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.insertItemAt("one", 0);
        comboBox.addItem("two");
        comboBox.addItem("three");
        comboBox.addItem("four");
        jPanel.add(comboBox);

        JSlider jSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 20);
        jSlider.setMajorTickSpacing(20);
        jSlider.setMinorTickSpacing(10);
        jSlider.setSnapToTicks(true);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jPanel.add(jSlider);

        jPanel.setBorder(titled);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
