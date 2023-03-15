package com.sds.algorithm;

import java.util.Stack;
import java.util.Scanner;

/**
 *  20.有效括号
 * Created by shu.ds on 2023/3/13
 **/
public class Solution20 {
    public boolean isValid(String s){
        // 1 参数合法性校验
        if(!s.isEmpty() && s.length() % 2 == 1) return false;

        // 2 声明辅助变量
        Stack<Character> st = new Stack<>();

        // 3 遍历字符串校验
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '[') st.push(']');
            else if(c == '{') st.push('}');
            else if(st.empty() || st.peek() != c) return false;
            else st.pop();
        }

        // 4 返回结果
        return st.empty();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution20 so = new Solution20();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(so.isValid(line));
        }
    }
}
