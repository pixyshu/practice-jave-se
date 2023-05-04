package com.sds.algorithm;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1 参数合法性校验
        if (nums.length == 0 || k > nums.length) {
            return new int[0];
        }

        // 2 声明辅助变量
        Map<Integer, Integer> mp = new HashMap<>();
        for (Integer e : nums) {
            mp.put(e, mp.getOrDefault(e, 0) + 1);
        }


        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

        // 3 遍历得到结果
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }

        // 4 返回结果
        return res.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] numStrArr = s.split(" ");
        int[] nums = Arrays.stream(numStrArr).mapToInt(e -> Integer.parseInt(e)).toArray();
        int k = sc.nextInt();
        Solution347 so = new Solution347();
        int[] resArr = so.topKFrequent(nums, k);
        for (Integer e : resArr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
