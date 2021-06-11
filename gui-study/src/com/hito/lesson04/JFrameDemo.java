package com.hito.lesson04;
import javax.swing.*;

public class JFrameDemo {
    //init(); 初始化
    public void init(){
        JFrame jFrame = new JFrame("这是一个JFrame窗口");
        jFrame.setVisible(true);
        jFrame.setBounds(100,100,300,400);

        //设置文字 JLabel
        JLabel jLabel = new JLabel("欢迎来到我的窗口");
        jFrame.add(jLabel);

        //容器

        //关闭事件
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
