package com.sds.test;

import java.util.Scanner;


// 定义链表节点
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}


public class Main{
    public boolean hasCycle(ListNode head){
        // 1 参数合法性校验
        if(head ==  null) return false;

        // 2 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next == null) return false;
            fast = fast.next.next;
            if(fast == slow) return true;
        }

        // 3 如果不存在环节点，返回false
        return false;
    }

    public ListNode createList(int n, int pos){
        // 1 定义控制台输入对象
        Scanner sc = new Scanner(System.in);

        // 2 获取值并创建链表
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        String line = sc.nextLine();
        String[] lineVal = line.split(" ");
        for(String val : lineVal){
            ListNode node = new ListNode(Integer.parseInt(val));
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }


        // 3 按要求指定环
        ListNode head = dummyNode.next;
        while(pos-- != 0 && head != null){
            head = head.next;
        }
        tail.next = head;

        // 4 返回链表
        return dummyNode.next;
    }


    // 测试用例
    public static void main(String[] args){
        // 1 声明对象实例
        Main so = new Main();

        // 2 创建链表
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        ListNode head = so.createList(n, pos);

        // 3 检查链表是否存在环
        boolean res = so.hasCycle(head);
        System.out.println(res);
    }
}