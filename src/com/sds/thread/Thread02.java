package com.sds.thread;

/**
 * TODO
 * Created by shu.ds on 2022/12/14
 **/
public class Thread02 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();

    }
}

class ThreadProxy implements Runnable {
    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        target.run();
    }


    // 通过代理实现线程的创建并执行
    public void start() {
        start0();
    }

    private void start0() {
        run();
    }
}

class Animal {
}


class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫～～～");
    }
}

