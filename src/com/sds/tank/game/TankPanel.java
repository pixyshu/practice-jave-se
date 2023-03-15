package com.sds.tank.game;

import sun.util.resources.cldr.my.CurrencyNames_my;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class TankPanel extends JPanel implements KeyListener {
    Hero hero = null;

    Vector<Enemy> enemies = new Vector<>();
    private  int enemySize = 3;

    public TankPanel() {
        this.hero = new Hero();
        hero.setX(200);
        hero.setY(200);
        hero.setType(1);
        hero.setSpeed(10);
        hero.setDirect(0);


        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy();
            enemy.setX((i + 1) * 100);
            enemy.setDirect(2);
            enemy.setType(0);
            enemies.add(enemy);
        }

    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, 1000, 750);

        // 画出敌人的坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), enemy.getType());
        }

        // 画出我方坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getType());
    }

    /**
     * @param x 乌龟的左上角x坐标
     * @param y 乌龟的左上角y坐标
     */
    private void drawTurtle(int x, int y, Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 30, 40);

    }

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // 根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克方向绘制坦克
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);  // 炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);  // 画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 坦克圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);  // 炮筒
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);  // 炮筒
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);  // 画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 坦克圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);  // 炮筒
                break;
            default:
                System.out.println("暂时没有要处理的");

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
