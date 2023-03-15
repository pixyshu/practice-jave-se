package com.sds.tank.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class BallonMove extends JFrame {
    MyPanle mp = null;

    public BallonMove() {
        mp = new MyPanle();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        BallonMove ballonMove = new BallonMove();
    }

}

class MyPanle extends JPanel implements KeyListener {
    int x = 20, y = 20;
    @Override
    public void paint(Graphics g) {
        g.fillOval(x, y, 20, 20);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

