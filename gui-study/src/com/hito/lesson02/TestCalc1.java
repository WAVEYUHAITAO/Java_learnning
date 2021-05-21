package com.hito.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCalc1 {
    public static void main(String[] args) {
        new Calculator();
    }

}

class Calculator1 extends Frame{
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
        button.addActionListener(new MyCalculatorListener1(this));
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

    public static void closeFrame(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

//监听器类
class MyCalculatorListener1 implements ActionListener{
    //获取计算器这个对象,在一个类中组合另一个类
    //这种方法更好,相比于TestCalc进行了代码优化,更加的面向对象
    Calculator1 calculator1 = null;
    public MyCalculatorListener1(Calculator1 calculator1) {
        this.calculator1 = calculator1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //1.获得加数和被加数
        int n1 = Integer.parseInt(calculator1.num1.getText());
        int n2 = Integer.parseInt(calculator1.num2.getText());


        //2.将这个值加法运算后，放到第三个框
        calculator1.num3.setText(""+(n1+n2));

        //3.清除前两个框
        calculator1.num1.setText("");
        calculator1.num2.setText("");
    }
}

