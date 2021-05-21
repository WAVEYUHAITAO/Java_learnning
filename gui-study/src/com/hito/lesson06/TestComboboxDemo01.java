package com.hito.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestComboboxDemo01 extends JFrame {
    public TestComboboxDemo01(){
        Container container = this.getContentPane();
        //下拉框
        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("正在上映");
        status.addItem("已下架");
        status.addItem("即将上映");

        container.add(status);

        //列表框
        //生成列表的内容
        //列表,展示信息，一般是动态的
        String[] contents = {"1","2","3"};

        Vector vector = new Vector();
        vector.add("张三");
        vector.add("李四");
        vector.add("王五");
        //列表中需要放内容
        JList jList = new JList(contents);
        JList jList1 = new JList(vector);
        container.add(jList);
        container.add(jList1);

        //文本框
        JTextField jTextField1 = new JTextField("hello");
        JTextField jTextField2 = new JTextField("world",10);
        container.add(jTextField1);
        container.add(jTextField2);


        //密码框
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        container.add(jPasswordField);


        container.setLayout(new GridLayout(6,1));
        this.setVisible(true);
        this.setSize(500,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo01();
    }

}
