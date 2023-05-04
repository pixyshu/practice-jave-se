package com.sds.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution904 {

    public int totalFruit(int[] fruits){
        // 1 参数合法性校验
        if(fruits.length == 0) return 0;

        // 2 定义辅助变量
        Map<Integer, Integer> basket = new HashMap<>();
        int maximun = Integer.MIN_VALUE;

        // 3 窗口指针循环遍历
        for(int i = 0, j = 0; j < fruits.length; j++){
            basket.put(fruits[j], basket.get(fruits[j]) + 1);

            while (basket.size() > 2){
                basket.put(fruits[i], basket.get(fruits[i]) - 1);
                if(basket.get(fruits[i]) == 0) basket.remove(fruits[i]);
                i++;
            }

            maximun = Math.max(maximun, j - i + 1);
        }

        // 4 返回结果
        return maximun;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] numStrArr = line.split(" ");
        int[] nums = new int[numStrArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numStrArr[i]);
        }
        Solution904 so = new Solution904();
        int i = so.totalFruit(nums);
        System.out.println(i);

    }
}
