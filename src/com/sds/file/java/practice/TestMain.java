package com.sds.file.java.practice;

import javax.swing.tree.TreeNode;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/15
 **/
public class TestMain {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid + 1]){
                right = mid;    // 在左边寻找峰值
            }else{
                left = mid + 1; // 在右边寻找峰值
            }
        }

        return left;
    }


    public static int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;

        while(right < nums.length){
            if(sum < target){
                sum += nums[right];
                right++;
            }else{
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int k = 7;

    }
}

