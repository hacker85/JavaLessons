package swing.awt;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.*;

public class PringLesson {
    public static void main(String[] args) {
        Printable canvas = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex == 0) {
                    Graphics2D g2 = (Graphics2D) graphics;

                    g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                    Line2D line2D = new Line2D.Double(0,0,100,100);
                    g2.draw(line2D);

                    return (PAGE_EXISTS);
                }
                return (NO_SUCH_PAGE);
            }
        };
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(canvas);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
