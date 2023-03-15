package com.sds.thread.ticket;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class SellTicket01 extends Thread {
    private  static  int ticketNum = 100;

    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();

        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
    }


    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束" + "...");
                break;
            }

            try {
                Thread.sleep(50);
                System.out.println("窗口" + Thread.currentThread().getName() +"正在售票ing..." + "剩余票数：" + (--ticketNum));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
