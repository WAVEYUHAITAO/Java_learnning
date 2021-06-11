package com.hito.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

//图标，需要实现类，Frame继承
public class TestIconDemo extends JFrame implements Icon {
    private int width;
    private int height;

    public TestIconDemo(){
    }
    public TestIconDemo(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void init(){
        TestIconDemo iconDemo = new TestIconDemo(15, 15);
        JLabel jLabel = new JLabel("iconTest", iconDemo, SwingConstants.CENTER);
        JLabel jLabel1 = new JLabel("iconTest1");
        //添加一个图片到label
        URL url = TestIconDemo.class.getResource("Terraria.png");
        ImageIcon imageIcon = new ImageIcon(url);
        jLabel1.setIcon(imageIcon);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        Container container = this.getContentPane();
        container.add(jLabel);
        container.add(jLabel1);
        this.setLayout(new GridLayout(2,1));
        this.setVisible(true);
        this.setBounds(200,200,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestIconDemo().init();
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
