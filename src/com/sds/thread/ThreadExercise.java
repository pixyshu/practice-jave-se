package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class ThreadExercise {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new T4());

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if (i == 5) {
                t.start();
                t.join();
            }
            Thread.sleep(1000);
        }
    }
}


class T4 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}