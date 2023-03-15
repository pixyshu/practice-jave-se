package com.sds.tank.game02;

/**
 * TODO
 * Created by shu.ds on 2022/12/16
 **/
public class Shot implements Runnable {
    private Bullet bullet = null;

    public Shot(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override

    public void run() {
        while (true) {
            try {
                // 每500毫秒更新一次子弹的坐标
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bullet.shot();

            System.out.println("子弹发射坐标 -> " + "(" + bullet.getX() + "," + bullet.getY() + ")");
            if (!(bullet.getX() >= 0 && bullet.getX() <= 1000 && bullet.getY() >= 0 && bullet.getY() <= 750)) {
                System.out.println("子弹超出边界，子弹线程销毁");
                bullet.setAlive(false);
                break;
            }
        }
    }
}
