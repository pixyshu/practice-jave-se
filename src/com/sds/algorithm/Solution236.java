package com.sds.algorithm;

import java.util.*;

public class Solution236{
	// 两个二叉树节点的最近公共
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null) return root;
		return left != null ? left : right;
	}

	public static void main(String[] args){
		// 1 实例化输入输出对象实例
		Scanner sc = new Scanner(System.in);
		
		// 2 输入测试用例并转换成数组
		List<Integer> nums = new ArrayList<>();
		String line = sc.nextLine();
		String[] strs = line.split(" ");
		for(String str : strs){
			if(str.equals("#")){
				nums.add(null);
			}else{
				nums.add(Integer.parseInt(str));
			}
		}
		Integer[] array = nums.toArray(new Integer[nums.size()]);

		// 3 生成二叉树
		TreeNode root = TreeNodeUtil.arrayToTreeNode(array);

		// 4 输入测试用例
		// 3 5 1 6 2 0 8 # # 7 4
		while(sc.hasNextLine()){
			String params = sc.nextLine();
			String[] paramArray = params.split(" ");
			TreeNode p = TreeNodeUtil.findTarget(root, Integer.parseInt(paramArray[0]));
			TreeNode q = TreeNodeUtil.findTarget(root, Integer.parseInt(paramArray[1]));

			if(p != null && q != null){
				Solution236 so = new Solution236();
				TreeNode resNode = so.lowestCommonAncestor(root, p, q);
				System.out.println(resNode.val);
			}else{
				System.out.println("目前值不存在，请重新输入");
			}
		}

		
	}
}