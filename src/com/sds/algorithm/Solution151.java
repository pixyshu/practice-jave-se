package com.sds.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution151 {
    public String reverseWords(String s){
        // 1 参数合法性校验
        if (s == "" || s.length() == 0) {
            return s;
        }

        // 2 处理成字符串数组
        List<String> strList = split(s.trim());

        // 3 翻转字符串
        String reuslt = reverseString(strList);

        // 4 返回结果
        return reuslt;
    }

    public List<String> split(String s){
        if(s.length() == 0 || s == null){
            return null;
        }

        String tmp = "";
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                tmp += ch;
            }else if(!tmp.isEmpty()){
                result.add(tmp);
                tmp = "";
            }else{
                continue;
            }
        }
        result.add(tmp);

        return result;
    }

    private String reverseString(List<String> strList){
        if(strList.isEmpty()){
            return null;
        }

        String result = "";
        for(int i = strList.size() - 1; i > 0; i--){
            result += strList.get(i) + " ";
        }
        result += strList.get(0);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution151 so = new Solution151();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String s = so.reverseWords(str);
            System.out.println(s);
        }

    }
}
