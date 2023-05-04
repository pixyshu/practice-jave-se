package com.sds.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

// 创建二叉树工具类
public class TreeNodeUtil {
    public static TreeNode arrayToTreeNode(Integer[] array) {
        // 1 参数合法性校验
        if (array.length == 0) return null;

        // 2 声明辅助变量
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isLeft = true;

        // 3 循环遍历树组，创建二叉树
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.add(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.add(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }

        // 4 返回变量
        return root;
    }


    // 查找目标节点
    public static TreeNode findTarget(TreeNode root, int target) {
        if(root == null) return null;
        if(root.val == target) return root;

        TreeNode node = null;
        node = findTarget(root.left, target);
        if(node != null) return node;

        node = findTarget(root.right, target);
        return node;
    }
}
