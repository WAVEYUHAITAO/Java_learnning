package com.hito.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //定义蛇的数据结构
    int length; //蛇的长度
    int[] snakeX = new int[600]; //蛇的x坐标
    int[] snakeY = new int[600]; //蛇的y坐标
    String direction;
    //食物的坐标
    int foodx;
    int foody;
    int score; //游戏得分，吃一个得10分
    Random random = new Random();

    //游戏当前的状态：开始  停止
    boolean isStart = false; //默认不开始

    boolean isFail = false; //判断游戏失败

    boolean isWin = false; //判断游戏胜利条件

    //定时器， 以毫秒为单位
    Timer timer = new Timer(200,this); //1000ms刷新一次，执行一次

    public GamePanel() {
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//游戏一开始定时器启动
    }

    public void init(){
        length = 3;
        snakeX[0]=100;snakeY[0]=100; //脑袋的坐标
        snakeX[1]=75;snakeY[1]=100; //第一个身体
        snakeX[2]=50;snakeY[2]=100; //第二个身体
        direction = "R"; //初始化方向向右
        foodx = 25+25*random.nextInt(34);
        foody = 25+25*random.nextInt(24);
        score=0;
    }


    //绘制画板，我们游戏中的所有东西，都是用这个画笔来画
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏效果
        this.setBackground(Color.yellow);//设置面板背景色
        //绘制静态页面
        Data.header.paintIcon(this,g,25,11);  //头部广告栏画上去
        g.fillRect(25,75,850,600);  //游戏的界面画上去
        Data.food.paintIcon(this,g,foodx,foody);  //把食物画上去
        // 绘制游戏积分板块
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        g.drawString("长度：" + length, 680, 30);
        g.drawString("分数：" + score, 680, 55);
        //把小蛇画上去
        if(direction.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]); //蛇头初始化向右，需要通过方向来判断
        }else if(direction.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]); //蛇头初始化向右，需要通过方向来判断
        }else if(direction.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]); //蛇头初始化向右，需要通过方向来判断
        }else if(direction.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]); //蛇头初始化向右，需要通过方向来判断
        }

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]); //绘制小蛇身体的长度不超过length
        }

        //游戏开始前提示
        if(isStart == false){
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.ITALIC,40)); //设置字体
            g.drawString("按下空格开始游戏",300,300);
            g.drawString("吃一个得10分",300,350);
        }
        //游戏失败，结束提示
        if(isFail){
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败,按下空格重新开始",300,300);
            g.drawString("吃一个得10分",300,350);
        }
        if(isWin){
            g.setColor(Color.GREEN);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏胜利,按下空格重新开始",300,300);
            g.drawString("吃一个得10分",300,350);
        }

    }
    //事件监听--需要通过固定的时间来刷新，1s=10次
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail == false && isWin == false){//如果游戏是开始状态，让小蛇动起来
            //失败判断，撞到自己就算失败
            //增加一个如果食物随机到蛇身上，自动重新再随机一个食物
            for (int i = 1; i < length ; i++) {
                if(foodx == snakeX[i] && foody == snakeY[i]){
                    //再次随机食物位置
                    foodx = 25+25*random.nextInt(34);
                    foody = 75+25*random.nextInt(24);
                }
                if(snakeX[0] == snakeX[i] &&snakeY[0] ==snakeY[i]){
                    isFail = true;
                }
            }
            //吃食物
            if(snakeX[0] ==foodx && snakeY[0] ==foody){
                length++; //长度+1
                score+=10;
                if(score>=50){
                    isWin = true;
                }
                //再次随机食物位置
                foodx = 25+25*random.nextInt(34);
                foody = 75+25*random.nextInt(24);
            }
            //右移, 右移代码要在走向判断之前,不然头会缩进去,身体第一段和头重合
            //因为如果走向判断在前，snakeX[0]的坐标改变在先,蛇神第一节会覆盖头部
            for (int i = length-1; i >0 ; i--) {//后一节移动到前一节的位置
                snakeX[i]= snakeX[i - 1];//向前移动一节
                snakeY[i]= snakeY[i - 1];//向前移动一节
            }
            //走向判断
            if(direction.equals("R")){
                snakeX[0]=snakeX[0] +25;
                if(snakeX[0]>850){//边界判断
                    snakeX[0]=25;
                }
            }else if(direction.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){//边界判断
                    snakeX[0]=850;
                }
            }else if(direction.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if(snakeY[0]<75){//边界判断
                    snakeY[0]=650;
                }
            }else if(direction.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if(snakeY[0]>650){//边界判断
                    snakeY[0]=75;
                }
            }

            repaint(); //重画页面
        }
        timer.start();//定时器开始
    }
    // 定时器执行的操作

//    public void actionPerformed(ActionEvent e) {
//        // TODO Auto-generated method stub
//        // 如果游戏处于开始状态，并且没有结束，则蛇可以移动
//        if (isStart && isFail == false) {
//            // 右移：让后一个移到前一个的位置即可
//            for (int i = length - 1; i > 0; i--) {
//                snakeX[i] = snakeX[i - 1];
//                snakeY[i] = snakeY[i - 1];
//            }
//            // 贪吃蛇头部按照按键控制的方向移动
//            if (direction.equals("R")) {
//                snakeX[0] = snakeX[0] + 25;// 蛇头向右移动一个单位：25为一个单位
//                if (snakeX[0] >= 850) {
//                    // snakeX[0] = 50;//如果蛇头超出有边界则贪吃蛇从墙的左边出来
//                    isFail = true;// 贪吃蛇撞墙，游戏失败
//                }
//            } else if (direction.equals("D")) {// 蛇头向下移动一个单位
//                snakeY[0] = snakeY[0] + 25;
//                if (snakeY[0] >= 725) {
//                    // snakeY[0] = 100;//如果蛇头超出有边界则贪吃蛇从墙的上边出来
//                    isFail = true;// 贪吃蛇撞墙，游戏失败
//                }
//            } else if (direction.equals("L")) {// 蛇头向左移动一个单位
//                snakeX[0] = snakeX[0] - 25;
//                if (snakeX[0] <= 25) {
//                    // snakeX[0] = 850;//如果蛇头超出有边界则贪吃蛇从墙的右边出来
//                    isFail = true;// 贪吃蛇撞墙，游戏失败
//                }
//            } else if (direction.equals("U")) {// 蛇头向上移动一个单位
//                snakeY[0] = snakeY[0] - 25;
//                if (snakeY[0] <= 75) {
//                    // snakeY[0] = 725;//如果蛇头超出有边界则贪吃蛇从墙的下边出来
//                    isFail = true;// 贪吃蛇撞墙，游戏失败
//                }
//            }
//            // 如果蛇头到达食物位置，则把食物吃掉
//            if (snakeX[0] == foodx && snakeY[0] == foody) {
//                length++; // 蛇的长度加一
//                score += 10;// 分数加10
//                // 更新食物坐标
//                foodx = 50 + 25 * random.nextInt(32);
//                foody = 100 + 25 * random.nextInt(24);
//            }
//            // 循环判断蛇头是否撞到蛇身
//            for (int i = 1; i < length; i++) {
//                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
//                    isFail = true;// 如果蛇头撞到蛇身则游戏结束
//                }
//            }
//            //repaint();
//            repaint(25, 0, 850, 745);// 不断的更新游戏区域页面，实现动画效果
//            timer.start();//启动计时器
//        }
//    }
    //键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();  //获得键盘keycode是哪一个
        if(keyCode == KeyEvent.VK_SPACE){ //按下的是空格
            if(isFail){
                isFail = false;
                init();
            }else if (isWin){
                isWin = false;
                init();
            }else {
                isStart = !isStart; //isStart取反
            }
            repaint();
        }
        //小蛇移动
        if(keyCode == KeyEvent.VK_UP){
            if(direction.equals("D")==false){
                direction="U";
            }
        }else if(keyCode == KeyEvent.VK_DOWN){
            if(direction.equals("U")==false){
                direction="D";
            }

        }else if(keyCode == KeyEvent.VK_LEFT){
            if(direction.equals("R")==false){
                direction="L";
            }
        }else if(keyCode == KeyEvent.VK_RIGHT){
            if(direction.equals("L")==false){
                direction="R";
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


}


