package com.sds.tank.game05;

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
    // 定义我方坦克
    Hero hero = null;
    // 定义敌方坦克
    Vector<Enemy> enemies = new Vector<>();
    private int enemySize = 3;
    // 定义一个Vector，用于存放炸弹， 当子弹击中坦克时，就加入一个Bomb对象
    Vector<Bomb> bombs = new Vector<>();

    // 定义三张图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public TankPanel() {
        // 创建我方坦克
        this.hero = new Hero(200, 300);
        hero.setType(1);
        hero.setSpeed(10);
        hero.setDirect(0);
        hero.setShots(new Vector<>());


        // 初始化敌人坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemyTank = new Enemy((i + 1) * 100, 20);
            enemyTank.setDirect(2);
            enemyTank.setType(0);
            // 启动随机运动线程
            new Thread(enemyTank).start();

            // 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();

            enemies.add(enemyTank);
        }

        // 加载图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

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
        for (int i = 0; i < hero.getShots().size(); i++) {
            Shot shot = hero.getShots().get(i);
            if (shot != null && shot.isLive()) {
                System.out.println("子弹被绘制");
                g.fill3DRect(shot.getX(), shot.getY(), 2, 2, false);
            } else {
                hero.getShots().remove(shot);
            }
        }


        // 如果bombs集合对象中有，就画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

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
    public void hitTank(Shot s, Enemy enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0: // 坦克向上
            case 2: // 坦克向下
                if (s.getX() >= enemyTank.getX() && s.getX() <= enemyTank.getX() + 40
                        && s.getY() >= enemyTank.getY() && s.getY() <= enemyTank.getY() + 60) {
                    s.setLive(false);
                    enemyTank.setAlive(false);
                    enemies.remove(enemyTank);
                    // 创建Bomb对象，加入到Bombs中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: // 坦克向右
            case 3: // 坦克向左
                if (s.getX() >= enemyTank.getX() && s.getX() <= enemyTank.getX() + 60
                        && s.getY() >= enemyTank.getY() && s.getY() <= enemyTank.getY() + 40) {
                    s.setLive(false);
                    enemyTank.setAlive(false);
                    enemies.remove(enemyTank);
                    // 创建Bomb对象，加入到Bombs中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 我方坦克的上下左右移动
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() >= 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 <= 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 80 <= 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() >= 0) {
                hero.moveLeft();
            }
        }

        // 我方坦克的子弹发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            // 确保子弹存在只能发送一颗
//            if (hero.getShot() == null || !hero.getShot().isLive()) {
//                hero.shotEnemy();
//            }

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
            for (Shot shot : hero.getShots()) {
                if (shot != null && shot.isLive()) {
                    for (int i = 0; i < enemies.size(); i++) {
                        Enemy enemy = enemies.get(i);
                        hitTank(shot, enemy);
                    }
                }
            }

            // 画板重绘
            this.repaint();
        }
    }
}
