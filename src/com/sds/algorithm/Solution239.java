package com.sds.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class MyPriorityQueue{
    private Deque<Integer> que = null;

    public MyPriorityQueue(){
        this.que = new ArrayDeque<>();
    }

    public void add(int e){
        while (!que.isEmpty() && e > que.getLast()) {
            que.removeLast();
        }
        que.addLast(e);
    }

    public void poll(int e){
        if (!que.isEmpty() && que.getLast() == e) {
            que.removeFirst();
        }
    }

    public int peek(){
        return que.getFirst();
    }
}

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1 合法性校验
        if(nums.length == 0 || k > nums.length) return new int[0];

        // 2 定义辅助变量
        MyPriorityQueue que = new MyPriorityQueue();
        List<Integer> list = new ArrayList<>();

        // 3 滑动窗口
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);
        }
        list.add(que.peek());

        for (int i = k; i < nums.length; i++) {
            que.poll(nums[i - k]);
            que.add(nums[k]);
            list.add(que.peek());
        }

        // 4 返回结果
        return list.stream().mapToInt(e -> e).toArray();

    }
}
