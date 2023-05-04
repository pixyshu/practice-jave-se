package com.sds.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution150 {

    public int evalRPN(String[] tokens){
        // 1 参数合法性校验
        if(tokens.length == 0) return 0;

        // 2 定义辅助变量
        Deque<Integer> deque = new ArrayDeque<>();

        // 3 遍历Token数组
        for (String op : tokens) {
            if (op.equals("+")) {
                deque.addLast(deque.pollLast() + deque.pollLast());
            } else if (op.equals("-")) {
                int num1 = deque.pollLast();
                int num2 = deque.pollLast();
                deque.addLast(num2 - num1);
            } else if (op.equals("*")) {
                deque.addLast(deque.pollLast() * deque.pollLast());
            } else if (op.equals("/")) {
                int num1 = deque.pollLast();
                int num2 = deque.pollLast();
                deque.addLast(num2 / num1);
            } else{
                deque.addLast(Integer.parseInt(op));
            }
        }

        // 4 返回结果
        return deque.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution150 so = new Solution150();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] tokens = s.split(" ");
            int res = so.evalRPN(tokens);
            System.out.println(res);
        }
    }
}
