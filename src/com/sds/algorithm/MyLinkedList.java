package com.sds.algorithm;

public class MyLinkedList<E> {
    class ListNode{
        E val;
        ListNode next;
        ListNode(){}
        ListNode(E e){
            this.val = e;
        }
        ListNode(E e, ListNode next){
            this.val = e;
            this.next = next;
        }
    }

    ListNode first;
    ListNode last;
    int n = 0;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        n = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    /**
     * 快慢指针, 相交于C
     * 快：AB + BC + BC
     * 慢：
     * @param index
     * @return
     */

    public E get(int index){
        if(index < 0 && index >= size()){
            throw new RuntimeException("Index out of LinkedList");
        }

        ListNode cur = first;
        while(cur!= null && index-- != 0){
            cur = cur.next;
        }

        return  cur.val;
    }

    public void addAtHead(E e){
        ListNode node = new ListNode(e);
        if (isEmpty()){
            first = node;
            last = first;
        }else {
            node.next = first;
            first = node;
        }
        n++;
    }

    public void addAtTail(E e){
        ListNode oldLast = last;
        ListNode last = new ListNode(e);
        if(isEmpty())
            first = last;
        else{
            oldLast.next = last;
        }
        n++;
    }

    public void addAtIndex(int index, E e) {
        if (index < 0 && index > n) throw new RuntimeException("Index out of LinkedList");

        if (index == n - 1){
            addAtTail(e);
        } else if (index == 0) {
            addAtHead(e);
        }else {
            ListNode pre = new ListNode();
            while (index-- != 0){
                pre = pre.next;
            }
            ListNode node = new ListNode(e);
            node.next = pre.next;
            pre.next = node;
            n++;
        }
    }

    public void deleteAtIndex(int index) {

    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addAtHead(23);
        list.addAtHead(30);
        list.addAtHead(40);
        System.out.println(list.size());
        list.addAtTail(10);
        System.out.println(list.size());

    }
}
