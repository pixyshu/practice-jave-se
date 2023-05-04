package com.sds.algorithm.datastruct;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/**
 * 使用两个队列实现一个后入先出的栈
 * @param <E> 参数类型
 * q1:
 * q2: 4 3 2 1
 */
public class MyStack<E> {
    private Queue<E> queIn = null;
    private Queue<E> queOut = null;

    public MyStack(){
        this.queIn = new ArrayDeque<>();
        this.queOut = new ArrayDeque<>();
    }

    public void push(E e) {
        queIn.add(e);
        while (!queOut.isEmpty()) {
            queIn.add(queOut.poll());
        }
        swap(queIn, queOut);
    }

    private void swap(Queue<E> queIn, Queue<E> queOut) {
        Queue<E> tempQue = queIn;
        queIn = queOut;
        queOut = tempQue;
    }

    public E pop() {
        return queOut.poll();
    }

    public E top() {
        return queOut.peek();
    }

    public boolean empty() {
        return queOut.isEmpty();
    }
}
