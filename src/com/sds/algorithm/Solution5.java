package com.sds.algorithm;

import com.sds.test.Solution;

import java.util.Scanner;

/**
 * 5.最长回文子串
 * link: https://leetcode.cn/problems/longest-palindromic-substring/
 * Created by shu.ds on 2023/3/13
 **/
public class Solution5 {
    // 获取最长回文子串
    public String longestPanlidrome(String s){
        // 1 参数合法性校验
        if(s.length() < 2) return s;

        // 2 声明变量
        int maxLen = 1;
        int begin = 0;

        // 3 回文判断并更新最长回文的长度
        for(int i = 0; i < s.length(); i++){
            // 剪枝操作，不存在比目前更大的子串，则直接退出循环
            if(s.length() - i < maxLen - 1) break;
            // 双重循环遍历，逐个子串进行比较，并更新子串长度和起始坐标
            for(int j = i + 1; j < s.length(); j++){
                if(maxLen < (j - 1 + 1) && isValidPanlidrome(s, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        // 4 返回最长回文子串
        return s.substring(begin, begin + maxLen);
    }

    // 判断回文子串的合法性
    public boolean isValidPanlidrome(String s, int left, int right){
        // 1 合法性校验
        if(left > right) return false;

        // 2 回文字符判断
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }

        return true;
    }


    // 测试用例
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            Solution5 so = new Solution5();
            String substr = so.longestPanlidrome(str);
            System.out.println(substr);
        }
    }
}
