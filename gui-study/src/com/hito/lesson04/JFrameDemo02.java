package com.hito.lesson04;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJFrame02().init();
    }
}

class MyJFrame02 extends JFrame{
    public void init(){
        setBounds(500,200,200,300);
        setVisible(true);
        //添加标签
        JLabel jLabel = new JLabel("欢迎来到我的窗口");
        add(jLabel);

        //让文本标签居中
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //获得一个容器
        Container container = getContentPane();
        container.setBackground(Color.BLUE);

        //关闭
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
