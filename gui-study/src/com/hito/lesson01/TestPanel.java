package com.hito.lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(12, 208, 12));

        //panel 设置坐标相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(201, 37, 59));

        //添加面板
        frame.add(panel);

        frame.setVisible(true);


        //监听事件，监听关闭窗口的事件
        //适配器模式
        frame.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                //结束程序
            }
        });
    }
}
