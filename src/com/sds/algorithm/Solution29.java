package com.sds.algorithm;

import com.sds.algorithm.ListNode;

public class Solution29{

	/**
	 * 删除链表的倒数第N个节点
	 * 
	 * head = [1,2,3,4,5], n = 2
	 */
	public ListNode removeNthFromEnd(ListNode head, int n){
		// 1 合法性校验
		if(head == null) return head;

		// 2 定义快慢指针
		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		ListNode fast = head;
		ListNode slow = dummyNode;


		// 3 找到倒数N节点的前一个节点并删除
		int count = n;
		while(count-- != 0){
			if(fast.next == null) return head;
			fast = fast.next;
		}

		while(fast != null){
			fast.next = fast;
			slow = slow.next;
		}

		slow.next = slow.next.next;


		return dummyNode.next;
	}

}




