package com.sds.algorithm;

import java.util.Scanner;

public class Solution202 {

    public int nextNum(int n){
        int sum = 0;
        while(n > 0){
            int e = n % 10;
            n = n / 10;
            sum += e * e;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = nextNum(n);
        while (fast != 1 && slow != fast) {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution202 so = new Solution202();
        while (sc.hasNext()){
            int e = sc.nextInt();
            boolean happy = so.isHappy(e);
            System.out.println(happy);
        }


    }
}
