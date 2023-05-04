package com.sds.algorithm;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Scanner;

public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        // 1 合法性校验
        if (s == "" || s.length() == 0) {
            return false;
        }

        // 2 进行重复字符串的判断
        String tmp = s + s;
        String temp = tmp.substring(1, tmp.length() - 1);
        if (tmp.contains(s)) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Solution459 so = new Solution459();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(so.repeatedSubstringPattern(sc.next()));
        }
    }
}
