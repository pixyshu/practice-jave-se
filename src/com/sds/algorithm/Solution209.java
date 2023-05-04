package com.sds.algorithm;

import java.util.Scanner;

public class Solution209 {

    public int minSubArray(int[] nums, int target){
        // 1 参数合法性校验
        if(nums.length == 0) return 0;

        // 2 定义窗口指针
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        // 3 窗口滑动遍历
        for (int i = 0, j = 0; j < nums.length; i++) {
            sum += nums[j];

            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
        }

        // 4 返回结果
        return minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        sc.nextLine();  // 跳过一行
        String line = sc.nextLine();
        String[] numStr = line.split(" ");
        int[] nums = new int[numStr.length];

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }

        Solution209 so = new Solution209();
        int minLen = so.minSubArray(nums, target);
        System.out.println(minLen);

    }
}
