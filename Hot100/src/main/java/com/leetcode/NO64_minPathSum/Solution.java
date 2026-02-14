package com.leetcode.NO64_minPathSum;

import java.util.Arrays;
import java.util.Stack;

/*
方法一，递归，DFS,单纯的递归会导致超时，加上记忆化搜索
方法二，将递归变为循环
方法三，使用dp，注意动态规划和递归实际上是一个思想：能由dp解决，一定能由递归解决；能由递归解决，一定能由do解决
 */
class Solution {
    class Point{
        int x;
        int y;
        int sum;
        Point(int x,int y,int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    public int minPathSum(int[][] grid) {
        //方法一，使用dfs，加上记忆化搜索
//        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];
//        return dfs(grid,0,0,hasVisited);

        //方法二，直接循环
//        dfsByStack(grid);

        //方法三，dp
        //dp[i][j]表示从i,j到grid.length-1,grid[0].length-1的最短路径
        //dp[i][j] = Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j]
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int i = grid.length-1;i>=0;i--){
            for(int j = grid[0].length-1;j>=0;j--){
                int lastSum = j==grid[0].length-1?dp[i+1][j]:i==grid.length-1?dp[i][j+1]:Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = lastSum + grid[i][j];
            }
        }
        return dp[0][0];
    }
    public int dfsByStack(int[][] grid){
        Stack<Point> stack = new Stack<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int[] vis:visited){
            Arrays.fill(vis,Integer.MAX_VALUE);
        }
        stack.push(new Point(0,0,grid[0][0]));

        while(!stack.isEmpty()){
            Point nowPoint = stack.pop();
            int nowX = nowPoint.x;
            int nowY = nowPoint.y;
            int nowSum = nowPoint.sum;
            visited[nowX][nowY] = nowSum;
            if (nowY + 1 < grid[0].length){
                int nextSum = nowSum+grid[nowX][nowY+1];
                if (nextSum < visited[nowX][nowY+1] ){
                    stack.push(new Point(nowX,nowY+1,nextSum));
                }
            }
            if (nowX+1 < grid.length){
                int nextSum = nowSum+grid[nowX+1][nowY];
                if (nextSum < visited[nowX+1][nowY]){
                    stack.push(new Point(nowX+1,nowY,nextSum));
                }
            }
        }
        return visited[grid.length-1][grid[0].length-1];
    }
    public int dfs(int[][] grid,int x,int y,boolean[][] hasVisited){
        if (x <0 || x >=grid.length || y < 0 || y >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if (hasVisited[x][y]){
            return grid[x][y];
        }
        int left = dfs(grid,x,y+1,hasVisited);
        int right = dfs(grid,x+1,y,hasVisited);
        int result = Math.min(left,right);
        grid[x][y] += (result==Integer.MAX_VALUE ? 0 :result);
        hasVisited[x][y] = true;
        return  grid[x][y];
    }
}