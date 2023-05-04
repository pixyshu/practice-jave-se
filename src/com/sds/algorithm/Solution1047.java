package com.sds.algorithm;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution1047 {
    public String removeDuplicates(String s){
        if(s.equals("") || s.length() == 0) return s;

        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (deque.peekLast() == ch) {
                deque.removeLast();
            }else{
                deque.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        deque.stream().forEach(e -> sb.append(e));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1047 so = new Solution1047();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(so.removeDuplicates(sc.next()));

        }
    }
}
