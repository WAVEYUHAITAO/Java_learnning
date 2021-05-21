package com.hito.lesson03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{
    public void loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        //画笔，需要有颜色，画笔可以画画
        g.setColor(Color.red);
        g.drawOval(100,100,100,200);
        g.fillOval(200,100,100,200);

        g.setColor(Color.green);
        g.fillRect(100,100,200,100);

        //养成习惯，画笔用完，将他还原到最初的颜色
    }
}