package com.sds.tank.game05;

/**
 * TODO
 * Created by shu.ds on 2022/12/16
 **/
public class Bomb {
    int x, y; // 炸弹的坐标
    int life = 9;   // 炸弹的生命周期
    boolean isLive = true;  // 是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void  lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}


