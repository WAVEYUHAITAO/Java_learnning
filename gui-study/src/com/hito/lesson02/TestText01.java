package com.hito.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestText01 {
    public static void main(String[] args) {
        //启动！
        new MyFrame();
    }
}

class MyFrame extends Frame{
    public MyFrame() {
        TextField textField = new TextField();
        add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField field = (TextField) e.getSource(); //e.getSource()是返回一个object

                String string = field.getText();//获得输入框中的文本,按下回车就可以输出到terminal
                System.out.println(string);
                field.setText("");
            }
        });
        textField.setEchoChar('*');//设置替换字符
        setVisible(true);
        pack();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
