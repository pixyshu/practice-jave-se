package com.sds.tank.swing;

import javax.swing.*;
import java.awt.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10, 10, 30, 30);

    }
}
