package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class ThreadMethodJoin {
    public static void main(String[] args) throws InterruptedException {

    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程（老大）吃了" + (++i) + "个包子～～");
        }
    }
}


