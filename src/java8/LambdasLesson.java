package java8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdasLesson {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
            }
        };
        Runnable runnable1 = () -> System.out.println("hello");
        String s = "hello";
        ActionListener actionListener1 = (ActionEvent event) -> {
            System.out.println(s);
        };
        //A a = () -> System.out.println("hello");
    }
}
interface A {
    void one(int i);
    void two();
}
