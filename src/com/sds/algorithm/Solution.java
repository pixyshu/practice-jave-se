package com.sds.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    /**
     * abcdabcde
     */
    public String[] getMaxString(String str){

        List<String> list = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if(set.contains(str.charAt(j))){
                    if(j - i> maxLen) list.clear();
                    if(j - i < maxLen) break;
                    maxLen = j - i;
                    list.add(str.substring(i, i + maxLen));
                    break;
                }
                if (j == str.length() - 1) {
                    if(j - i + 1> maxLen) list.clear();
                    if(j - i + 1 < maxLen) break;
                    maxLen = j - i + 1;
                    list.add(str.substring(i, i + maxLen));
                    break;
                }
                set.add(str.charAt(j));
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution so = new Solution();
        String[] maxString = so.getMaxString(str);
        for (String st : maxString) {
            System.out.println(st);
        }


    }
}
