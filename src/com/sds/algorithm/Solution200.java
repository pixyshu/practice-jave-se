package com.sds.algorithm;

import java.util.Scanner;

/**
 * TODO
 * Created by shu.ds on 2023/3/13
 **/
public class Solution200 {
    private int ans = 0;
    private int[][] dir = {{0,-1}, {0, 1}, {-1,0}, {1,0}};

    public int numIslands(char[][] grid){
        // 1 参数合法性校验
        if(grid == null) return 0;

        // 2 声明变量
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // 3 逐个元素进行遍历
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        // 4 返回结果
        return ans;
    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y){
        // 1 当当前元素已经被遍历过或者不是‘1’时直接返回
        if(visited[x][y] || grid[x][y] == '0'){
            return;
        }

        // 2 重置已经遍历过的元素状态
        visited[x][y] = true;

        // 3 进行dfs遍历
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length){
                dfs(grid, visited, nx, ny);
            }
        }

    }

    /**
     * 输入用例：
     * 4 5
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        // 用来跳过行列后的回车符
        sc.nextLine();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        Solution200 so = new Solution200();
        int num = so.numIslands(grid);
        System.out.println(num);
    }
}
