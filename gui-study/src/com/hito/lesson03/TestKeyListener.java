package com.hito.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestKeyListener {
    public static void main(String[] args) {
        new KeyFrame();
    }

}

class KeyFrame extends Frame{
    public KeyFrame() {
        setBounds(200,200,300,400);
        setVisible(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘当前按下的键的码
                int keyCode = e.getKeyCode();
                char keyChar = e.getKeyChar();
                System.out.println(keyCode);
                System.out.println(keyChar);
                if(keyCode == KeyEvent.VK_UP){
                    System.out.println("你按了上键");
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

