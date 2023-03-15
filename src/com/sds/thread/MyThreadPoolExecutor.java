package com.sds.thread;

import jdk.nashorn.internal.ir.Block;
import sun.tools.jconsole.Worker;

import javax.swing.*;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * Created by shu.ds on 2023/2/20
 **/
public class MyThreadPoolExecutor implements Executor {
    // 记录线程池中线程数量
    private final AtomicInteger ctl = new AtomicInteger(0);

    // 核心线程池数
    private volatile int corePoolSize;
    // 最大线程数
    private volatile int maximumPoolSize;

    // 阻塞队列
    private final BlockingQueue<Runnable> workQueue;

    // 初始化构造函数
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSizeIn, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSizeIn;
        this.workQueue = workQueue;
    }


    @Override
    public void execute(Runnable command) {
        int c = ctl.get();
        // 如果当前线程数小于核心线程数，则执行任务
        if (c < corePoolSize) {
            if (!addWorker(command)) {
                reject();
            }
            return;
        }

        // 如果大于，则放入到工作队列，并尝试执行
        if (!workQueue.offer(command)) {
            if (!addWorker(command)) {
                reject();
            }
        }
    }

    /**
     * 饱和策略
     */
    private void reject() {
        throw new RuntimeException("Can not execute! ctl.count: " + ctl.get() + "workQueue size: " + "workQueue size: " + workQueue.size());
    }

     private boolean addWorker(Runnable firstTask) {
        // 校验当前线程大小是否超过最大线程数
        if (ctl.get() >= maximumPoolSize) {
            return false;
        }
        Worker worker = new Worker(firstTask);
        // 启动线程
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }

    private final class Worker implements Runnable {
        final Thread thread;
        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }

        @Override
        public void run() {
            Runnable task = firstTask;
            try {
                // 只要当前任务不为空，或者队列任务不为空，就取出任务执行
                while (task != null || (task = getTask()) != null) {
                    task.run();
                    if (ctl.get() > maximumPoolSize) {
                        break;
                    }
                    task = null;
                }
            }finally {
                ctl.decrementAndGet();
            }
        }

        private Runnable getTask() {
            while (true) {
                try {
                    System.out.println(" workQueue size: " + workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public static void main(String[] args) {

        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(2, 2, new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 10; i++) {
            int taskNum = i;
            myThreadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " **** " + taskNum);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务编号：" + taskNum);
            });

            HashMap<Object, Object> hp = new HashMap<>();

        }
    }


}
