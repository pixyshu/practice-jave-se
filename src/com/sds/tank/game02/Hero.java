package com.sds.tank.game02;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Hero extends Tank {
    private Bullet bullet;

    public Hero() {

    }

    public Hero(int x, int y) {
        super(x, y);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public void shotEnemy() {
        // 根据当前坦克的方法，创建子弹对象
        switch (getDirect()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }

        // 根据创建好的子弹，创建子弹射击线程任务并执行
        Thread shotThread = new Thread(new Shot(bullet));
        shotThread.start();

    }
}
