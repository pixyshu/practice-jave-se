package com.sds.tank.game03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class TankPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;

    Vector<Enemy> enemies = new Vector<>();
    private int enemySize = 3;

    public TankPanel() {
        this.hero = new Hero(200, 300);
        hero.setType(1);
        hero.setSpeed(10);
        hero.setDirect(0);


        // 初始化敌人坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemyTank = new Enemy((i + 1) * 100, 20);
            enemyTank.setDirect(2);
            enemyTank.setType(0);
            // 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();

            enemies.add(enemyTank);
        }

    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, 1000, 750);

        // 画出敌人的坦克
        for (int i = 0; i < enemies.size(); i++) {
            // 取出坦克
            Enemy enemyTank = enemies.get(i);
            // 如果坦克存活，则画出坦克
            if (enemyTank.isAlive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), enemyTank.getType());
                // 画出enemyTank的所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive()) {
                        g.fill3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

        // 画出我方坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getType());

        // 画出我方坦克子弹
        if (hero.getShot() != null && hero.getShot().isLive()) {
            System.out.println("子弹被绘制");
            g.fill3DRect(hero.getShot().getX(), hero.getShot().getY(), 2, 2, false);
        }
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


    // 判断我方坦克是否击中敌方坦克
    public static void hitTank(Shot s, Enemy enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0: // 坦克向上
            case 2: // 坦克向下
                if (s.getX() >= enemyTank.getX() && s.getX() <= enemyTank.getX() + 40
                        && s.getY() >= enemyTank.getY() && s.getY() <= enemyTank.getY() + 60) {
                    s.setLive(false);
                    enemyTank.setAlive(false);
                }
                break;
            case 1: // 坦克向右
            case 3: // 坦克向左
                if (s.getX() >= enemyTank.getX() && s.getX() <= enemyTank.getX() + 60
                        && s.getY() >= enemyTank.getY() && s.getY() <= enemyTank.getY() + 40) {
                    s.setLive(false);
                    enemyTank.setAlive(false);
                }
                break;
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

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemy();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 判断是否击中敌人坦克
            if (hero.getShot() != null && hero.getShot().isLive()) {
                for (int i = 0; i < enemies.size(); i++) {
                    Enemy enemy = enemies.get(i);
                    hitTank(hero.getShot(), enemy);
                }
            }

            // 画板重绘
            this.repaint();
        }
    }
}
