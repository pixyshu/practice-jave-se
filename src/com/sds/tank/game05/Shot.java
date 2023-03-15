package com.sds.tank.game05;

/**
 * TODO
 * Created by shu.ds on 2022/12/16
 **/
public class Shot implements Runnable {
    private int x;
    private int y;
    private int direct; // 0 上 1 右 2 下 3 左
    private int speed;
    private int DEFAULT_SPEED = 2;
    private boolean isLive = false;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = DEFAULT_SPEED;
        isLive = true;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true) {
            // 每20毫秒，进行子弹位置更新
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            System.out.println("子弹位置 x = " + x + ", y = " + y);
            // 结束线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive())) {

                System.out.println("子弹线程销毁~~~");
                isLive = false;
                break;
            }
        }
    }
}
