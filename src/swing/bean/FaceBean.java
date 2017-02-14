package swing.bean;

import javax.swing.*;
import java.awt.*;

public class FaceBean extends JComponent {
    private int mMouthWidth = 90;
    private boolean mSmile = true;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Face
        int w = getWidth();
        int h = getHeight();
        int pad = 12;
        int cw = w - pad * 2;
        int ch = h - pad * 2;
        g2.setColor(getBackground());
        g2.fillArc(pad, pad, cw, ch, 0, 360);
        g2.setColor(getForeground());
        g2.drawArc(pad, pad, cw, ch, 0, 360);
        // Mouth
        int sw = cw / 2;
        int sh = ch / 2;
        if (mSmile == true)
            g2.drawArc(w / 2 - sw / 2, h / 2 - sh / 2, sw, sh, 270 - mMouthWidth / 2, mMouthWidth);
        else
            g2.drawArc(w / 2 - sw / 2, h / 2 + sh / 3, sw, sh, 90 - mMouthWidth / 2, mMouthWidth);
        // Eyes
        int er = 4;
        g2.fillArc(w / 2 - cw * 1 / 8 - er / 2, h / 2 - ch / 4 - er, er, er, 0, 360);
        g2.fillArc(w / 2 + cw * 1 / 8 - er / 2, h / 2 - ch / 4 - er, er, er, 0, 360);
    }

    public int getMouthWidth() {
        return mMouthWidth;
    }

    public void setMouthWidth(int mw) {
        mMouthWidth = mw;
        repaint();
    }

    public void smile() {
        mSmile = true;
        repaint();
    }

    public void frown() {
        mSmile = false;
        repaint();
    }
}