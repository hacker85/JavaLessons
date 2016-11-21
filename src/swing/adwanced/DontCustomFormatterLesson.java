package swing.adwanced;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.text.ParseException;

public class DontCustomFormatterLesson {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    static DefaultFormatter defaultFormatter = new DefaultFormatter(){
        @Override
        public Object stringToValue(String string) throws ParseException {
            System.out.println(string);
            return "bla";
            //System.out.println("stringToValue " + string);
            //throw new ParseException("bla", 5);
            //return super.stringToValue("(" + string + ")");// "(" + string + ")";
//            StringTokenizer tokenizer = new StringTokenizer(string, ".");
//            byte[] a = new byte[4];
//            for (int i = 0; i < 4; i++)
//            {
//                int b = 0;
//                try
//                {
//                    b = Integer.parseInt(tokenizer.nextToken());
//                }
//                catch (NumberFormatException e)
//                {
//                    throw new ParseException("Not an integer", 0);
//                }
//                if (b < 0 || b >= 256)
//                    throw new ParseException("Byte out of range", 0);
//                a[i] = (byte) b;
//            }
//            return a;
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if(value !=null && value.toString().equals("bla")) {
                throw new ParseException("al",5);
            }
            System.out.println("valueToString " + value);
            //return (value == null) ? "()" : "(" + value.toString() + ")";
            return "bla";
//            if (!(value instanceof byte[]))
//                throw new ParseException("Not a byte[]", 0);
//            byte[] a = (byte[]) value;
//            if (a.length != 4)
//                throw new ParseException("Length != 4", 0);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < 4; i++)
//            {
//                int b = a[i];
//                if (b < 0) b += 256;
//                builder.append(String.valueOf(b));
//                if (i < 3) builder.append('.');
//            }
//            return builder.toString();
        }
    };

    public static void main(String[] args) {
        jFrame.add(jPanel);

        defaultFormatter.setOverwriteMode(false);
        JFormattedTextField jFormattedTextField = new JFormattedTextField(defaultFormatter);

        jPanel.add(jFormattedTextField);
        jFormattedTextField.setColumns(10);
        jFrame.revalidate();
    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 500, 500, 500);
        return jFrame;
    }
}
