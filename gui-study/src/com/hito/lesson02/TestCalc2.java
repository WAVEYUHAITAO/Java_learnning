package com.hito.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCalc2 {
    public static void main(String[] args) {
        new Calculator();
    }

}

class Calculator2 extends Frame{
    //属性
    TextField num1,num2,num3;

    //方法
    public void loadFrame(){
        //3个文本
        TextField num1 = new TextField(10);
        TextField num2 = new TextField(10);
        TextField num3 = new TextField(20);
        //1个按钮
        Button button = new Button("=");
        //监听器
        button.addActionListener(new MyCalculatorListener1());
        //1个标签
        Label label = new Label("+");

        //布局
        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
        closeFrame(this);
    }
    //监听器类
    class MyCalculatorListener1 implements ActionListener{
        //内部类

        @Override
        public void actionPerformed(ActionEvent e) {
            //1.获得加数和被加数
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());


            //2.将这个值加法运算后，放到第三个框
            num3.setText(""+(n1+n2));

            //3.清除前两个框
            num1.setText("");
            num2.setText("");
        }
    }

    public static void closeFrame(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}



