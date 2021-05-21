package com.hito.snake;

import javax.swing.*;
import java.net.URL;

public class Data {

    //相对路径  tx.jpg
    //绝对路径  /com/hito/snake/贪吃蛇的头.png
    public static URL headerURL = Data.class.getResource("advertise_head.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    public static URL upURL = Data.class.getResource("head_up.png");
    public static URL downURL = Data.class.getResource("head_down.png");
    public static URL leftURL = Data.class.getResource("head_left.png");
    public static URL rightURL = Data.class.getResource("head_right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bodyURL = Data.class.getResource("body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    public static URL foodURL = Data.class.getResource("food.png");
    public static ImageIcon food = new ImageIcon(foodURL);
}
