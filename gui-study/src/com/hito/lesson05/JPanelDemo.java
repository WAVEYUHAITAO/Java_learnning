package com.hito.lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo() {
        Container container = this.getContentPane();

        container.setLayout(new GridLayout(2,1,10,10));

        JPanel jPanel1 = new JPanel(new GridLayout(1,3));
        JPanel jPanel2 = new JPanel(new GridLayout(1,2));
        JPanel jPanel3 = new JPanel(new GridLayout(2,2));
        JPanel jPanel4 = new JPanel(new GridLayout(5,1));

        jPanel1.add(new JButton("1"));
        jPanel1.add(new JButton("1"));
        jPanel1.add(new JButton("1"));
        jPanel2.add(new JButton("2"));
        jPanel2.add(new JButton("2"));
        jPanel3.add(new JButton("3"));
        jPanel3.add(new JButton("3"));
        jPanel3.add(new JButton("3"));
        jPanel3.add(new JButton("3"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));
        jPanel4.add(new JButton("4"));

        container.add(jPanel1);
        container.add(jPanel2);
        container.add(jPanel3);
        container.add(jPanel4);
        this.setVisible(true);
        this.setBounds(300,300,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
