package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class ThreadMethod3 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread daemonThread = new MyDaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在辛苦工作。。。。");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋杰在快乐聊天。。。。。");
        }
    }
}
