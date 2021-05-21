package com.hito.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent2 {
    public static void main(String[] args) {
        //两个按钮，实现同一个监听
        //开始 停止
        Frame frame = new Frame("开始 - 停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        MyListener myListener = new MyListener();

        //button1.setActionCommand("btn2-stop");
        button1.addActionListener(myListener);
        button2.addActionListener(myListener);
        frame.setLayout(new GridLayout(2,1));
        button1.setActionCommand("btn1 is clicked");
        frame.add(button1);
        frame.add(button2);
        frame.setLocation(1000,500);
        frame.setSize(400,400);
        //frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        CloseWindow(frame);

    }
    //监听关闭的方法
    private static void CloseWindow(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
//新建自己的LISTENER
class MyListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了"+e.getActionCommand());
    }
}
