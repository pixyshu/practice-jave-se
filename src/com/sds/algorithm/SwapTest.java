package com.sds.algorithm;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

public class SwapTest {
    public static void Swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(20);
        Swap(a, b);
        System.out.println(" a = " + a + ", b = " + b);

    }
}
