package com.sds.tank.game03;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Tank {
    private int x;
    private int y;
    private int direct; // 0 上 1 右 2 下 3 左
    private int type;  // 0 青色敌军 1 黄色我军
    private int speed = 1;
    private boolean isAlive;

    public Tank() {
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    public void  moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }
    public void moveRight() {
        x += speed;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
