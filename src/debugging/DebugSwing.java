package debugging;

import javax.swing.*;

/**
 * Created by husiv on 10/11/16.
 */
public class DebugSwing {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        JButton button = new JButton("submit");
        //1
        //ctrl+shift+f1
        //2
        button.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
        jPanel.add(button);
        //3
        RepaintManager.currentManager(jFrame.getRootPane()).setDoubleBufferingEnabled(false);
        ((JComponent)jFrame.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
