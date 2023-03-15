package com.sds.jvm;

import com.sun.org.glassfish.external.amx.AMXGlassfish;
import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * TODO
 * Created by shu.ds on 2023/2/15
 **/
public class OOMObject {
    static List<Integer> ans = new ArrayList<>();
    static int num = 0;

    static void backtrace(int[] arr) {
        if (num > 100 && num <= 999) {
            ans.add(num);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
            backtrace(arr);
            num = num / 10;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(5);
//
//        Thread qiao = new Thread(countDownLatch::countDown);
//        Thread king = new Thread(countDownLatch::countDown);
//        Thread la = new Thread(countDownLatch::countDown);
//        Thread zha = new Thread(countDownLatch::countDown);
//        Thread kai = new Thread(() -> {
//            try {
//                Thread.sleep(1500);
//                countDownLatch.countDown();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        qiao.start();
//        king.start();
//        la.start();
//        zha.start();
//        kai.start();
//
//        countDownLatch.await();
//        System.out.println("所有玩家已准备就位！");

        System.out.println(Runtime.getRuntime().availableProcessors());

    }

//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        Thread qiao = new Thread(() -> waitToFight(countDownLatch));
//        Thread king = new Thread(() -> waitToFight(countDownLatch));
//        Thread la = new Thread(() -> waitToFight(countDownLatch));
//        Thread zha = new Thread(() -> waitToFight(countDownLatch));
//        Thread kai = new Thread(() -> waitToFight(countDownLatch));
//
//        qiao.start();
//        king.start();
//        la.start();
//        zha.start();
//        kai.start();
//        Thread.sleep(1000);
//        countDownLatch.countDown();
//        System.out.println("所有玩家已准备就位！");
//    }
//
//    private static void waitToFight(CountDownLatch countDownLatch) {
//        try {
//            countDownLatch.await(); //在此等待信号再继续
//            System.out.println("收到， 发起进攻");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
