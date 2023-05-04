package com.sds.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        // 1 参数合法性校验
        if(t.length() > s.length() || t == "" || s == "") return "";

        // 2 声明并初始化辅助变量
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0,right = 0;
        int count = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        // 3 滑动窗口
        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    count++;
                }
            }

            while(count == need.size()){
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }

        // 4 返回结果
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }

    public static void main(String[] args) {

    }
}
