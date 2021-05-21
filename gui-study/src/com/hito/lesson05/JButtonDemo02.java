package com.hito.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02 extends JFrame{
    public JButtonDemo02(){
        Container container = this.getContentPane();
        URL url = JButtonDemo02.class.getResource("intellj.png");
        ImageIcon imageIcon = new ImageIcon(url);

        //单选框
        JRadioButton jRadioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton03 = new JRadioButton("JRadioButton03");

        //由于单选框只能选择一个，分组,一个组中只能选择一个
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        buttonGroup.add(jRadioButton03);
        this.setLayout(new FlowLayout());
        container.add(jRadioButton02);
        container.add(jRadioButton01);
        container.add(jRadioButton03);

        //多选框
        JCheckBox checkBox01 = new JCheckBox("CheckBox01");
        JCheckBox checkBox02 = new JCheckBox("CheckBox02");
        JCheckBox checkBox03 = new JCheckBox("CheckBox03");
        container.add(checkBox01);
        container.add(checkBox02);
        container.add(checkBox03);

        this.setVisible(true);
        this.setBounds(400,300,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
