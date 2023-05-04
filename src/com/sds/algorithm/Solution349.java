package com.sds.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution349{

	public int[] intersection(int[] nums1, int[] nums2){
		// 1 参数合法性判断
		if(nums1.length == 0 || nums2.length == 0){
			return null;
		}

		// 2 声明辅助变量
		List<Integer> ans = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		// 3 遍历两个数组
		for(int e : nums1){
			set.add(e);
		}

		for(int e : nums2){
			if(set.contains(e) && !ans.contains(e)){
				ans.add(e);
			}
		}

		// 4 返回结果
		return ans.stream().mapToInt(Integer::intValue).toArray();
	}
}