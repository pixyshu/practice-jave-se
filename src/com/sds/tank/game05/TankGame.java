package com.sds.tank.game05;

import javax.swing.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class TankGame extends JFrame {
    TankPanel tp = null;

    public TankGame() {
        tp = new TankPanel();
        // 创建并启动画板线程
        Thread thread = new Thread(tp);
        thread.start();

        this.add(tp);
        this.addKeyListener(tp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }
}
