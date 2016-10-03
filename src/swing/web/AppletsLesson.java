package swing.web;

import javax.swing.*;

/**
 * Created by husiv on 10/3/16.
 */
public class AppletsLesson extends JApplet {
    @Override
    public void init() {
        add(new JButton(getParameter("buttonName")));
    }
}
