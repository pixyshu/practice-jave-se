package com.sds.tank.game05;

import java.util.Vector;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Hero extends Tank {
    private Shot shot;
    private Vector<Shot> shots = null;
    private final int SHOT_SIZE = 5;

    public Hero() {
    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public void setShots(Vector<Shot> shots) {
        this.shots = shots;
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
        // 将创建的子弹加入到集合当中
        if (shots.size() + 1 <= SHOT_SIZE) {
            shots.add(shot);
        }

        Thread thread = new Thread(shot);
        thread.start();
    }
}
