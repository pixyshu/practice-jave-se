package com.sds.tank.swing;

import javax.swing.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class DrawTank extends JFrame {
    private MyPanel panel = null;

    public DrawTank() {
        panel = new MyPanel();
        this.add(panel);
        this.setSize(400, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new DrawTank();
    }
}

