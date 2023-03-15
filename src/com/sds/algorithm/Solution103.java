package com.sds.algorithm;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution103{

    /**
     * 链表创建
     * @param root
     * @param sc
     */
    void CreateTree(TreeNode root, Scanner sc){
        // 1 输入元素
        String e = sc.next();

        // 2 插入元素
        if(e.equals("#")){
            root = null;
        }else{
            root = new TreeNode(Integer.parseInt(e));
            CreateTree(root.left, sc);
            CreateTree(root.right, sc);
        }
    }


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
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode();
        
        Solution103 so = new Solution103();
        so.CreateTree(root, sc);
        List<List<Integer>> res = so.zigzagLevelOrder(root);
    }
}