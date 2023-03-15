package com.sds.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO
 * Created by shu.ds on 2023/2/24
 **/
public class TestDome {
    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        int k = 4;

        quickSort(nums, 0, nums.length - 1);
        int[] res = getKNums(nums, k);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int position = partition(nums, low, high);
        quickSort(nums, low, position - 1);
        quickSort(nums, position + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while(low < high && pivot <= nums[high]) high--;
            nums[low] = nums[high];
            while(low < high && pivot >= nums[low]) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    private static int[] getKNums(int[] nums, int k) {
        if(k > nums.length) return nums;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}
