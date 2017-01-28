package swing.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SplashLesson {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException, InterruptedException {
        SplashScreen splash = SplashScreen.getSplashScreen();
        Rectangle bounds = splash.getBounds();
        Graphics2D g = splash.createGraphics();
        g.setColor(Color.MAGENTA);
        for (int i = 0; i <= 100; i++) {
            g.fillRect(0, 0, bounds.width * i / 100, 20);
            splash.update();
        }

        final Image img = new ImageIcon(splash.getImageURL()).getImage();
        final JFrame splashFrame = new JFrame();
        final JPanel splashPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
            }
        };
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        splashPanel.setLayout(new BorderLayout());
        splashPanel.add(progressBar, BorderLayout.NORTH);
        splashFrame.add(splashPanel);
        splashFrame.setBounds(splash.getBounds());
        splashFrame.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                progressBar.setString("Loading module " + i);
                progressBar.setValue(i);
                splashPanel.repaint();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }

        splashFrame.setVisible(false);
    }
}
