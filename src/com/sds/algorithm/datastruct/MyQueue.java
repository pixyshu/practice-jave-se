package com.sds.algorithm.datastruct;

import java.util.Stack;

/**
 * 使用两个栈实现先入先出队列
 * @param <T>
 */
public class MyQueue<T> {
   private Stack<T> stackIn = null;
   private Stack<T> stackOut = null;


    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(T e){
        stackIn.add(e);
   }

   public T pop(){
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.add(stackIn.pop());
            }
        }
        return stackOut.pop();
   }

   public T peek(){
       if (stackOut.isEmpty()) {
           while (!stackIn.isEmpty()) {
               stackOut.add(stackIn.pop());
           }
       }
       return stackOut.peek();
   }

   public boolean empty(){
       return stackOut.empty() && stackIn.empty();
   }

}
