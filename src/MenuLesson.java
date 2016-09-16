import javax.swing.*;

/**
 * Created by husiv on 9/16/16.
 */
public class MenuLesson {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
