package com.sds.tank.game03;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Hero extends Tank {
    private Shot shot;

    public Hero() {
    }

    public Hero(int x, int y) {
        super(x, y);
    }


    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }


    public void shotEnemy() {
        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        Thread thread = new Thread(shot);
        thread.start();
    }
}
