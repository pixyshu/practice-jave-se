//import java.util.*
//
//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(){}
//	ListNode(int val){
//		this.val = val;
//	}
//}
//
//public Solution24{
//
//	public ListNode swapPairs(ListNode head){
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode pre = dummy, cur = head.next;
//
//        while(cur != null){
//            ListNode next = cur.next;
//            ListNode start = pre.next;
//
//            cur.next = start;
//            start.next = next;
//            pre.next = cur;
//            pre = start;
//
//            if(next == null) break;
//            cur = next.next;
//        }
//
//
//        return dummy.next;
//	}
//
//
//	public static void main(String[] args){
//
//	}
//}