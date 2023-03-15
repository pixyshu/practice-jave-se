package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("sds ");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + (++i));

        }
        t.interrupt();

    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + (++i) + " 吃饱了～～～");
        }

        try {
            System.out.println(Thread.currentThread().getName() + "休眠中～～～");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 被interrupt了");
            run();
        }

    }
}

