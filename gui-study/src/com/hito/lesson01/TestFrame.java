package com.hito.lesson01;

import java.awt.*;

//第一个界面
public class TestFrame {
    public static void main(String[] args) {
        //Frame ,JDK, 看源码
        Frame frame = new Frame("我的第一个java图像界面窗口");

        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置背景颜色
        frame.setBackground(new Color(89, 234, 12));

        //窗口弹出位置
        frame.setLocation(200,200);

        //设置大小固定, 边缘不可以拉伸
        frame.setResizable(false);
    }
}
