package com.sds.algorithm;

import java.util.Scanner;

public class Solution88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1 参数合法性校验
        if (m <= 0 || n <= 0) return;

        // 2 声明辅助变量
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur = -1;

        // 3 比较两个数组的值，从后往前进行赋值
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    // 测试实例
    public static void main(String[] args) {
        // 1 实例化控制台输入对象
        Scanner sc = new Scanner(System.in);

        // 2 声明并定义两个数组
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];

        // 3 输入两个数组的值
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                nums1[i] = sc.nextInt();
            }else{
                nums1[i] = 0;
            }
        }
        // 跳过换行符
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        // 4 调用对象方法
        Solution88 so = new Solution88();
        so.merge(nums1, m, nums2, n);

        for (int e : nums1) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}