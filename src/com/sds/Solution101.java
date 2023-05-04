package com.sds;

import com.sds.algorithm.Solution;
import com.sds.algorithm.TreeNode;
import com.sds.algorithm.TreeNodeUtil;

import java.util.*;

public class Solution101 {
    public boolean isSymmetric(TreeNode root){
        // 1 参数合法性校验
        if (root == null) {
            return false;
        }

        // 2 定义队列
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);


        // 3 逐层判断是否对称
        while (!que.isEmpty()) {
            int sz = que.size();
            List<Integer> list = new ArrayList<>();
            while(sz-- != 0){
                TreeNode node = que.pollFirst();
                if(node.left != null){
                    que.add(node.left);
                    list.add(node.left.val);
                }else{
                    list.add(-1);
                }
                if (node.right != null) {
                    que.add(node.right);
                    list.add(node.right.val);
                } else {
                    list.add(-1);
                }
            }
            if (!isSymmetric(list)) {
                return false;
            }
        }

        return true;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    private boolean isSymmetric(List<Integer> list) {
        if (list.size() % 2 == 1) {
            return false;
        }

        // 双指针遍历
        int low = 0, high = list.size() - 1;
        while (low < high) {
            if (list.get(low) != list.get(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution101 so = new Solution101();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] numStrArr = line.split(" ");
            Integer[] nums = new Integer[numStrArr.length];
            for (int i = 0; i < numStrArr.length; i++) {
                nums[i] = Integer.valueOf(numStrArr[i]);
            }

            TreeNode root = TreeNodeUtil.arrayToTreeNode(nums);
            boolean isSymmetric = so.isSymmetric(root);
            System.out.println(isSymmetric);
        }

    }
}
