package com.sds.tank.game05;

import java.util.Vector;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Enemy extends Tank implements Runnable{
    // 在敌人坦克，使用vector，保存多个shotø
    Vector<Shot> shots = new Vector<>();


    public Enemy() {
        setAlive(true);
    }

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() >= 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 <= 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 70 <= 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() >= 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            setDirect((int) (Math.random() * 4));

            // 如果为存活的状态，则终止该线程
            if (!isAlive()) {
                break;
            }
        }

    }
}
