package com.hito.snake1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.rmi.server.SkeletonMismatchException;
import java.util.Random;
import java.util.Timer;

import javax.naming.InitialContext;
import javax.naming.InsufficientResourcesException;
import javax.naming.directory.DirContext;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

public class StartGame {
    public static void main(String[] args) {
        // 初始化贪吃蛇游戏界面
        JFrame frame = new JFrame("贪吃蛇小游戏--bingongzi"); // 创建一个窗体对象
        frame.setSize(900, 800); // 设置窗体大小为900x800
        frame.setLocationRelativeTo(null); // 设置窗体为居中格式
        frame.setResizable(false); // 设置窗体不可改变

        frame.add(new GamePanel());// 在窗体中添加一个面板
        frame.setVisible(true); // 设置窗体可见
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 结束窗口所在的应用程序
    }
}

// 存储图片
class Data1 {
    // 面板logo url:定位图片的地址 ImageIcon:根据url获得图片
    // Class<T>中public URL getResource(String name)查找带有给定名称的资源。
    private static URL headerurl = Data1.class.getResource("advertise_head.png");
    public static ImageIcon header = new ImageIcon(headerurl);
    // 获取蛇头向上的图片
    private static URL upurl = Data1.class.getResource("head_up.png");
    public static ImageIcon up = new ImageIcon(upurl);
    // 获取蛇头向右的图片
    private static URL righturl = Data1.class.getResource("head_right.png");
    public static ImageIcon right = new ImageIcon(righturl);
    // 获取蛇头向下的图片
    private static URL downurl = Data1.class.getResource("head_down.png");
    public static ImageIcon down = new ImageIcon(downurl);
    // 获取蛇头向左的图片
    private static URL lefturl = Data1.class.getResource("head_left.png");
    public static ImageIcon left = new ImageIcon(lefturl);
    // 获取蛇身的图片
    private static URL bodyurl = Data1.class.getResource("body.png");
    public static ImageIcon body = new ImageIcon(bodyurl);
    // 获取食物的图片
    private static URL foodurl = Data1.class.getResource("food.png");
    public static ImageIcon food = new ImageIcon(foodurl);
}

// 用面板制作游戏界面
class GamePanel extends JPanel implements KeyListener, ActionListener {
    int len; // 定义贪吃蛇的长度
    int[] snakeX = new int[35]; // 定义蛇的横坐标x
    int[] snakeY = new int[28]; // 定义蛇的纵坐标y
    String dir = "R";// 蛇头方向:R：向右，D:向下，L：向左，U：向上
    boolean isStart = false;// 表示贪吃蛇游戏是否开始，初始化为还没开始
    javax.swing.Timer timer = new javax.swing.Timer(200, this);// 定时器，第一个参数：定时执行事件
    int foodX;// 定义食物的横坐标
    int foodY;// 定义食物的纵坐标
    int score;// 定义游戏得分
    Random random = new Random();// 创建随机数对象
    boolean isOver = false;// 表示游戏是否失败，结束
    // 初始化以上变量数据

    public GamePanel() {
        Init();
        this.setFocusable(true);// 获取焦点事件
        this.addKeyListener(this);// 添加键盘监听事件
        timer.start(); // 时间开始
    }

    // 初始化游戏数据
    public void Init() {
        len = 3;// 游戏开始前静态界面上，加上蛇头，有三节（蛇身两节）即蛇长度为3
        // 初始化蛇头位置
        snakeX[0] = 200;
        snakeY[0] = 200;
        // 初始化第一个蛇身位置
        snakeX[1] = 175;
        snakeY[1] = 200;
        // 初始化第二个蛇身位置
        snakeX[2] = 150;
        snakeY[2] = 200;
        dir = "R";// 初始化蛇头方向向右
        // 随机生成食物坐标
        foodX = 50 + 25 * random.nextInt(32);
        foodY = 100 + 25 * random.nextInt(25);
        // 游戏积分初始化为0
        score = 0;
    }

    // 画面板
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g); // 清屏效果
        this.setBackground(Color.white); // 设置面板的背景颜色
        Data1.header.paintIcon(this, g, 25, 10); // 绘制面板头部图片即（logo）
        g.fillRect(25, 75, 850, 675); // 绘制游戏区域
        // 绘制游戏积分板块
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        g.drawString("长度：" + len, 680, 30);
        g.drawString("分数：" + score, 680, 55);
        // 控制蛇头方向及位置
        if (dir.equals("R")) {// 当蛇头向右时
            Data1.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (dir.equals("D")) {// 当蛇头向下时
            Data1.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (dir.equals("L")) {// 当蛇头向左时
            Data1.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (dir.equals("U")) {// 当蛇头向上时
            Data1.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        // 绘制蛇身
        for (int i = 1; i < len; i++) {
            Data1.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        Data1.food.paintIcon(this, g, foodX, foodY);// 根据随机坐标绘制食物
        // 游戏开始前的提示
        if (isStart == false) {
            g.setColor(Color.white);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("按下空格键开始游戏", 245, 400);
            g.drawString("吃一个食物得10分", 265, 450);
        }
        // 游戏失败，结束
        if (isOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("宋体", Font.BOLD, 40));
            g.drawString("游戏失败，按下空格键则重新开始游戏", 100, 400);
            g.drawString("吃一个食物得10分", 260, 450);
        }
    }

    // 键盘监听事件:按键控制游戏是否开始
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        // 键盘按下未释放
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isOver) {// 当游戏失败时重新开始游戏
                isOver = false;
                Init();
                // new GamePanel();//重新进入游戏
            } else {// 当游戏为结束时，按下空格键暂停游戏
                // 如果按下空格键
                isStart = !isStart;// 控制游戏开关取反
            }
            repaint();// 重新绘制界面
        }
        // 按键上下左右控制贪吃蛇的头部方向
        if (keyCode == KeyEvent.VK_RIGHT) {
            if (dir.equals("L") == false) {
                dir = "R";// 如果蛇当前移动的方向不是向左时，则可以向右移动
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (dir.equals("U") == false) {
                dir = "D";// 如果蛇当前移动的方向不是向上时，则可以向下移动
            }
        } else if (keyCode == KeyEvent.VK_LEFT) {
            if (dir.equals("R") == false) {
                dir = "L";// 如果蛇当前移动的方向不是向右时，则可以向左移动
            }
        } else if (keyCode == KeyEvent.VK_UP) {
            if (dir.equals("D") == false) {
                dir = "U";// 如果蛇当前移动的方向不是向右时，则可以向左移动
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    // 定时器执行的操作
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // 如果游戏处于开始状态，并且没有结束，则蛇可以移动
        if (isStart && isOver == false) {
            // 右移：让后一个移到前一个的位置即可
            for (int i = len - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            // 贪吃蛇头部按照按键控制的方向移动
            if (dir.equals("R")) {
                snakeX[0] = snakeX[0] + 25;// 蛇头向右移动一个单位：25为一个单位
                if (snakeX[0] >= 850) {
                    // snakeX[0] = 50;//如果蛇头超出有边界则贪吃蛇从墙的左边出来
                    isOver = true;// 贪吃蛇撞墙，游戏失败
                }
            } else if (dir.equals("D")) {// 蛇头向下移动一个单位
                snakeY[0] = snakeY[0] + 25;
                if (snakeY[0] >= 725) {
                    // snakeY[0] = 100;//如果蛇头超出有边界则贪吃蛇从墙的上边出来
                    isOver = true;// 贪吃蛇撞墙，游戏失败
                }
            } else if (dir.equals("L")) {// 蛇头向左移动一个单位
                snakeX[0] = snakeX[0] - 25;
                if (snakeX[0] <= 25) {
                    // snakeX[0] = 850;//如果蛇头超出有边界则贪吃蛇从墙的右边出来
                    isOver = true;// 贪吃蛇撞墙，游戏失败
                }
            } else if (dir.equals("U")) {// 蛇头向上移动一个单位
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0] <= 75) {
                    // snakeY[0] = 725;//如果蛇头超出有边界则贪吃蛇从墙的下边出来
                    isOver = true;// 贪吃蛇撞墙，游戏失败
                }
            }
            // 如果蛇头到达食物位置，则把食物吃掉
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                len++; // 蛇的长度加一
                score += 10;// 分数加10
                // 更新食物坐标
                foodX = 50 + 25 * random.nextInt(32);
                foodY = 100 + 25 * random.nextInt(24);
            }
            // 循环判断蛇头是否撞到蛇身
            for (int i = 1; i < len; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isOver = true;// 如果蛇头撞到蛇身则游戏结束
                }
            }
            //repaint();
            repaint(25, 0, 850, 745);// 不断的更新游戏区域页面，实现动画效果
            timer.start();//启动计时器
        }
    }

}