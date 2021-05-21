package com.hito.lesson03;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}

class MyFrame extends Frame {
    //画画需要画笔，需要监听鼠标当前的位置，需要集合来存储这个点
    ArrayList points;
    public MyFrame(String title){
        super(title);
        //        setBounds(200,200,400,300);
        //        setVisible(true);
        //        //存鼠标点击的点
        //        points = new ArrayList();
        //        //鼠标监听器是相对于这个窗口
        this.addMouseListener(new MyMouseListener());
        MyWindowListener(this);
    }

    @Override
    public void paint(Graphics g) {
        //画画，监听鼠标的事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(point.x,point.y,10,10);
        }
    }
    private void MyWindowListener(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {//这个windowClosing是控制右上角的x
                System.out.println("窗口正关闭");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) { //暂不知用途
                System.out.println("窗口已关闭");

            }

            @Override
            public void windowActivated(WindowEvent e) {// 点击激活窗口
                System.out.println("窗口被激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) { // 失去窗口当前状态
                System.out.println("窗口未被激活");
            }

            @Override
            public void windowStateChanged(WindowEvent e) {//暂不知用途
                System.out.println("状态改变");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {//暂不知用途
                System.out.println("失去焦点");
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {//暂不知用途
                System.out.println("获得焦点");
            }
        });

    }

    //添加到界面上
//    public void addPoint(Point point){
//        points.add(point);
//    }

    private class MyMouseListener extends MouseAdapter {
        //鼠标按下，弹起，按住不放
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame myFrame = (MyFrame) e.getSource();

            points.add(new Point(e.getX(),e.getY()));

            //这里点击时就会在界面上产生一个点
            //myFrame.addPoint(new Point(e.getX(),e.getY()));
            //每次点击鼠标重新画一遍
            myFrame.repaint(); //刷新  30帧 60帧
            //添加一个按钮，每点击一次创建一个button
//            Button btn = new Button();
//            myFrame.add(btn);
//            myFrame.setLayout(new FlowLayout());
//            myFrame.setVisible(true);

        }

    }
}
