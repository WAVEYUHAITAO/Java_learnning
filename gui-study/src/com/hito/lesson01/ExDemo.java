package com.hito.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2,1));
        //4个面板
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");
        Button btn7 = new Button("btn7");
        Button btn8 = new Button("btn8");
        Button btn9 = new Button("btn9");
        Button btn10 = new Button("btn0");
        p2.add(btn2);
        p2.add(btn3);
        p1.add(btn1,BorderLayout.WEST);
        p1.add(btn4,BorderLayout.EAST);
        p1.add(p2,BorderLayout.CENTER);
        p4.add(btn6);
        p4.add(btn7);
        p4.add(btn8);
        p4.add(btn9);
        p3.add(btn5,BorderLayout.WEST);
        p3.add(p4,BorderLayout.CENTER);
        p3.add(btn10,BorderLayout.EAST);
        frame.add(p1);
        frame.add(p3);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
