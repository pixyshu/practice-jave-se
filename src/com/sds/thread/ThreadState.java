package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        T5 t = new T5();
        System.out.println("线程初始化状态：" + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }

        System.out.println(t.getName() + " 状态 " + t.getState());

    }
}

class T5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
