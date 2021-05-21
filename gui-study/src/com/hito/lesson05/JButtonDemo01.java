package com.hito.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {
    public JButtonDemo01(){
        Container container = this.getContentPane();
        URL url = JButtonDemo01.class.getResource("intellj.png");
        ImageIcon imageIcon = new ImageIcon(url);

        //把图标放在按钮上
        JButton button01 = new JButton();
        button01.setIcon(imageIcon);
        button01.setToolTipText("图片按钮");

        container.add(button01);
        pack();
        this.setVisible(true);
        this.setBounds(400,300,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
