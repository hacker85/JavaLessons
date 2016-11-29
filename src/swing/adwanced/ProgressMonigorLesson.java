package swing.adwanced;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static swing.adwanced.ProgressMonitorExample.counter;

public class ProgressMonigorLesson extends JFrame {
    static JFrame jFrame = new ProgressIndicatorLesson();
    public static void main(String[] args) throws IOException {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        ProgressMonitor progressMonitor = new ProgressMonitor(null, "Message", null, 0, 100);


        class Update implements Runnable {
            public void run() {
                if (progressMonitor.isCanceled()) {
                    progressMonitor.close();
                    System.exit(1);
                }
                progressMonitor.setProgress(counter);
                progressMonitor.setNote("Operation is "+counter+"% complete");
                counter += 2;
            }
        }

        SwingUtilities.invokeLater(new Update());

        jFrame.revalidate();

        //jPanel.add(jProgressBar);

//        for (int i = 0; i <= 100; i += 10) {
//            jProgressBar.setValue(i);
//            System.out.println(jProgressBar.getValue());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//        }
    }

    ProgressMonigorLesson() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        setBounds((int)dimension.getWidth()/4 - 250, (int)dimension.getHeight()/2 - 125, 500, 250);
    }
}