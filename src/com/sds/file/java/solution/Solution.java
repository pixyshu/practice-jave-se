package com.sds.file.java.solution;


import java.util.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/18
 **/
public class Solution {
    public static int similarPairs(String[] words) {
        int ans = 0;
        if (words.length == 0) {
            return ans;
        }

        List<HashSet<Character>> list = new ArrayList<>();
        for (String word : words) {
            HashSet<Character> set = new HashSet<>();
            for (Character ch : word.toCharArray()) {
                set.add(ch);
            }
            list.add(set);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static List<Integer> breakdown(int num) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                }
                list.add(i);
            }
        }
        if (num != 1) {
            list.add(num);
        }

        return list;
    }


    private static int breakNum(int num) {
        int ans = 0;

        for (int i = 2; i <= num / i; i++) {
            while (num % i == 0) {
                ans += i;
                num /= i;
            }
        }

        if (num > 1) {
            ans += num;
        }

        return ans;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    private int[][] dir = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}};

    private boolean bfs(char[][] board, int x, int y, boolean[][] used,String word, int index){
        if(board[x][y] != word.charAt(index)){
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }

        used[x][y] = true;
        boolean res = false;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(!(nx >= 0 && ny < board.length && ny >= 0 && ny < board[0].length && used[nx][ny] == false))  continue;
            boolean flag = bfs(board, nx, ny, used, word, index + 1);
            if (flag) {
                res = true;
                break;
            }
        }
        used[x][y] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];

        if(m == 0 || word.length() == 0){
            return false;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean flag = bfs(board, 0, 0, used, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k > len){
            return "0";
        }

        Deque<Character> stack = new LinkedList<>();

        for(Character c : num.toCharArray()){
            if(k != 0 && !stack.isEmpty() && c < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char c = stack.pollLast();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        quicksort(arr, k);

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr[i];
        }

        return res;
    }


    /** 快速排序函数 */
    private void quicksort(int[] arr, int k){
        quicksort(arr, 0, arr.length - 1, k);
    }

    /** 快速排序的具体实现 */
    private void quicksort(int[] arr, int low, int high, int k){
        changeRandomIndex(arr, low, high);

        int pos = partition(arr, low, high);
        int num = pos - low + 1;
        if(k == num) return;
        else if(k > num){
            quicksort(arr, pos + 1, high, k - num);
        }else{
            quicksort(arr, low, pos - 1, k);
        }
    }

    private void changeRandomIndex(int[] arr, int low, int high){
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(arr, 0, randomIndex);
    }

    private void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[0];
        while(low < high){
            while(low < high && pivot <= arr[high]) high--;
            arr[low] = arr[high];
            while(low < high && pivot >= arr[low]) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    private ListNode changeList(ListNode head) {
        // 合法性校验，链表为空或者只有一个元素直接返回
        if (head == null || head.next == null) {
            return  head;
        }

        // 定义两个链表虚拟头节点，dummy_odd dummy_even
        ListNode dummy_odd = new ListNode();
        ListNode odd_end = dummy_odd;
        ListNode dummy_even = new ListNode();
        ListNode even_pre = dummy_even;
        int count = 1;

        // 遍历链表，根据奇偶重新生成链表，奇链表正序排序，偶链表逆序排序
        while (head != null) {
            ListNode next = head.next;
            // 奇数链表操作，直接
            if (count % 2 != 0) {
                head.next = odd_end.next;
                odd_end.next = head;
                odd_end = head;
            } else {
                head.next = even_pre.next;
                even_pre.next = head;
            }
            head = next;
            count++;
        }

        // 链表合并
        ListNode p = dummy_odd.next;
        ListNode q = dummy_even.next;
        ListNode result = mergeList(p, q);

        // 返回结果
        return result;
    }

    private ListNode mergeList(ListNode p, ListNode q){
        if (p == null || q == null) {
            return p != null ? p : q;
        }

        ListNode dummy = new ListNode();
        ListNode end = dummy;
        while (p != null && q != null) {
            ListNode node1 = p.next;
            ListNode node2 = q.next;

            p.next = end.next;
            end.next = p;
            end = p;
            q.next = end.next;
            end.next = q;
            end = q;

            p = node1;
            q = node2;
        }

        end.next = q != null ? q : p;

        return dummy.next;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int value) {
            this.val = value;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for(int i = 0; i < n; i ++){
            for(int j = i + 1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution so = new Solution();
        so.dailyTemperatures(nums);
    }





}


