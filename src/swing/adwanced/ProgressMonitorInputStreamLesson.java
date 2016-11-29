package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressMonitorInputStreamLesson extends JFrame {

    static JFrame jFrame = new ProgressMonitorLesson();

    static ProgressMonitorInputStream progressIn;

    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream is = new FileInputStream("/home/max/todo.txt");
        progressIn = new ProgressMonitorInputStream(null, "caption", is);

        int i;
        while((i = progressIn.read())!=-1)
        {
            System.out.print((char)i);
            Thread.sleep(50);
        }
        progressIn.close();
    }

    ProgressMonitorInputStreamLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);


    }
}
