package com.hito.snake;

import javax.swing.*;
import java.awt.*;

//游戏主启动类
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");

        //设置窗口可见，大小，初始位置，关闭按钮，窗口尺寸不可调节。
        frame.setResizable(false);
        frame.setBounds(10,10,900,720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //正常游戏界面都应该在面板上
        Container container = frame.getContentPane();
        container.add(new GamePanel());

        frame.setVisible(true);

    }
}
