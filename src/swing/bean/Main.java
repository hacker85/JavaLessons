package swing.bean;

import javax.swing.*;
import java.awt.*;

/**
 * Created by max on 2/14/17.
 */
public class Main {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        FaceBean faceBean = new FaceBean();
        faceBean.setMouthWidth(50);
        faceBean.frown();
        jFrame.add(faceBean);
    }
    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 300);
        return jFrame;
    }
}
