package com.sds.algorithm;

import java.util.*;

public class Solution103{

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        // 1 声明并定义结果返回变量
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        // 2 参数合法性校验
        if(root == null) return res;
        int levelNo = 0;
        queue.add(root);
        
        // 3 进行层序遍历
        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> level = new ArrayList<>();
            while(sz-- != 0){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            // 根据层数控制链表的翻转
            if(++levelNo % 2 == 0){
                Collections.reverse(level);
            }

            res.add(level);
        }

        // 4 返回结果
        return res;

    }

    public static void main(String[] args){
        // 1 实例化输入输出对象
        Scanner sc = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();

        // 2 输入数据到数组
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        for (String str : strs) {
            if (str.equals("#")) {
                numList.add(null);
            } else {
                numList.add(Integer.parseInt(str));
            }
        }


        // 3 将列表转换成数组，并创建二叉树
        Integer[] nums = numList.toArray(new Integer[numList.size()]);
        TreeNode root = TreeNodeUtil.arrayToTreeNode(nums);

        // 4 进行二叉树的相应操作
        Solution103 so = new Solution103();
        List<List<Integer>> res = so.zigzagLevelOrder(root);
        System.out.println();

    }
}