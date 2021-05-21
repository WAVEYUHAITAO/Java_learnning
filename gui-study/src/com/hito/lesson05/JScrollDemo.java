package com.hito.lesson05;

import javax.swing.*;
import java.awt.*;
import java.util.ConcurrentModificationException;

public class JScrollDemo extends JFrame {
    public JScrollDemo() {
        Container container = this.getContentPane();

        //文本域
        JTextArea jTextArea = new JTextArea(20,60);
        jTextArea.setText("欢迎来到我的java");

        //Scroll面板,把文本域放进面板里
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        container.add(jScrollPane);


        this.setVisible(true);
        this.setBounds(400,300,500,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
