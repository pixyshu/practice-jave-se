package com.sds.file.java.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
class Solution {
    public static void main(String[] args) {
        String queryIp = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        Solution so = new Solution();
        System.out.println(so.validIPAddress(queryIp));

        String substring = queryIp.substring(5, 9);
        System.out.println(substring);

        String[] strings = so.split(queryIp, ':');
        for (String s : strings) {
            System.out.println(s);
        }

    }

    private String[] split(String s, char delimiter){
        int n = s.length(), l = 0;
        List<String> ans = new ArrayList<>();

        for(int r = 0; r < n; r++){
            if(s.charAt(r) == delimiter){
                ans.add(s.substring(l, r - l));
                l = r + 1;
            }
        }
        ans.add(s.substring(l, n - l));

        return ans.toArray(new String[ans.size()]);
    }

    public String validIPAddress(String queryIP) {
        int flag = judgeIp(queryIP);
        if(flag == 0) return "IPv4";
        else if(flag == 1) return "Ipv6";
        else return "Neither";
    }

    private int judgeIp(String queryIP){
        if(isIpv4(queryIP)){
            return 0;
        }else if(isIpv6(queryIP)){
            return 1;
        }else{
            return 2;
        }
    }

    private boolean isIpv4(String queryIP){
        // 参数合法性校验
        if(queryIP == null || queryIP.length() == 0){
            return false;
        }

        String[] ipNums = queryIP.split("\\.");
        if(ipNums.length != 4){
            return false;
        }

        for(String ipNum : ipNums){
            if(!judgeIpNum(ipNum)){
                return false;
            }
        }

        return true;
    }

    private boolean judgeIpNum(String ipNum){
        int len = ipNum.length();

        if(len > 3){
            return false;
        }

        if(ipNum.charAt(0) == '0' && len > 1){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < len; i++){
            char c = ipNum.charAt(i);

            if(c >= '0' && c <= '9'){
                sum = sum * 10 + (c - '0');
            }else{
                return false;
            }

            if(sum < 0 || sum > 255){
                return false;
            }
        }

        return true;
    }


    private boolean isIpv6(String queryIP){
        String[] ipNums = queryIP.split("\\:");

        if(ipNums.length != 8){
            return false;
        }

        for(String ipNum : ipNums){
            if(!isValidIPv6Num(ipNum)){
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv6Num(String ipNum){
        int len = ipNum.length();

        if(len > 4){
            return false;
        }

        for(int i = 0; i < len; i++){
            char c = ipNum.charAt(i);
            if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }
}
