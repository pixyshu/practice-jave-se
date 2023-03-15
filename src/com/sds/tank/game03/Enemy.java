package com.sds.tank.game03;

import java.util.Vector;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Enemy extends Tank {
    // 在敌人坦克，使用vector，保存多个shot
    Vector<Shot> shots = new Vector<>();


    public Enemy() {
        setAlive(true);
    }

    public Enemy(int x, int y) {
        super(x, y);
    }
}
