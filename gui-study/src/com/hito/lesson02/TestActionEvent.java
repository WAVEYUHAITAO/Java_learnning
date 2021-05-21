package com.hito.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发一些事件
        MyActionListener myActionListener = new MyActionListener();
        Frame frame = new Frame();
        Button button = new Button();

        button.addActionListener(myActionListener);
        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        windowClose(frame);

    }
    //关闭窗口 写成方法
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

//事件监听
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aa");
    }
}
