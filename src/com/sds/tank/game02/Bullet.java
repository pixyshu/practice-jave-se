package com.sds.tank.game02;

/**
 * TODO
 * Created by shu.ds on 2022/12/16
 **/
public class Bullet {
    private int x;
    private int y;
    private int direct;
    private int speed;
    private boolean isAlive;
    private final int DEFAULT_SPEED = 2;

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.isAlive = true;
        this.speed = DEFAULT_SPEED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void shot() {
        switch (getDirect()) {
            case 0: // 向上
                y -= speed;
                break;
            case 1: // 向右
                x += speed;
                break;
            case 2: // 向下
                y += speed;
                break;
            case 3: // 向左
                x -= speed;
                break;
        }
    }
}
