package com.sds.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p){
        // 1 定义结果返回变量
        List<Integer> ans = new ArrayList<>();

        // 2 参数合法性校验
        if(p.length() > s.length() || s == "" || p == "") return ans;

        // 3 定义辅助变量
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for(int i = 0; i < p.length(); i++){
            sArr[s.charAt(i) - 'a'] ++;
            pArr[p.charAt(i) - 'a'] ++;
        }

        // 4 循环遍历
        for(int i = 0; i < s.length() - p.length(); i++){
            if (Arrays.equals(sArr, pArr)) {
                ans.add(i);
            }
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i + p.length()) - 'a']++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        Solution438 so = new Solution438();
        List<Integer> ans = so.findAnagrams(s, p);
        ans.stream().forEach(e -> System.out.println(e + " "));
    }

}
