package swing.adwanced;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressMonitorExample extends JFrame implements ActionListener {

    static ProgressMonitor pbar;
    static int counter = 0;

    public ProgressMonitorExample() {
        setSize(250,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pbar = new ProgressMonitor(null, "Monitoring Progress",
                "Initializing . . .", 0, 100);

        Timer timer = new Timer(500, this);
        timer.start();
        setVisible(true);
    }

    public static void main(String args[]) {
        new ProgressMonitorExample();
    }

    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Update());
    }

    class Update implements Runnable {
        public void run() {
            if (pbar.isCanceled()) {
                pbar.close();
                System.exit(1);
            }
            pbar.setProgress(counter);
            pbar.setNote("Operation is "+counter+"% complete");
            counter += 2;
        }
    }
}