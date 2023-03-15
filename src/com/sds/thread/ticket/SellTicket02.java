package com.sds.thread.ticket;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class SellTicket02 implements Runnable {
    private static int ticketNum = 100;
    private boolean loop = true;
    Object o = new Object();

    public static void main(String[] args) {
        SellTicket02 task = new SellTicket02();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }


    private /*synchronized*/ void sell() {
        synchronized (o) {
            if (ticketNum <= 0) {
                System.out.println("售票结束" + "...");
                loop = false;
                return;
            }

            try {
                Thread.sleep(50);
                System.out.println("窗口" + Thread.currentThread().getName() + " 正在售票ing..." + "剩余票数：" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
