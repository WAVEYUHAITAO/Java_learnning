package com.hito.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    public DialogDemo(){
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //新建放东西的容器

        Container container = this.getContentPane();

        //绝对布局
        container.setLayout(null);

        //按钮
        JButton jButton = new JButton("点击弹出对话框");
        jButton.setBounds(30,30,200,50);

        //点击这个按钮，弹出一个弹窗
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                new MyDialogDemo();
            }
        });

        container.add(jButton);

    }

    public static void main(String[] args) {
        new DialogDemo();
    }
}
//弹窗的窗口,默认已经包含关闭的代码所以不用重复写
class MyDialogDemo extends JDialog{
    public MyDialogDemo() {
        this.setVisible(true);
        this.setBounds(100,100,500,500);

        Container container = this.getContentPane();

        container.setLayout(null);
        container.add(new JLabel("这是一个弹窗"));

    }
}

