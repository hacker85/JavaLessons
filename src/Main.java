import javax.swing.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws IOException, UnsupportedFlavorException, InterruptedException {

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}