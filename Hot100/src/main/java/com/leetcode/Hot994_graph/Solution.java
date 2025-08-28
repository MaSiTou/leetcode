package com.leetcode.Hot994_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int orangesRotting(int[][] grid) {
        int sum_x = grid.length;
        int sum_y = grid[0].length;
        int sum = 0;
        //遍历二维数组，当元素为2，入队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i < grid.length; i += 1){
            for (int j=0;j < grid[0].length; j += 1){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(true){
            //遍历队列
            int size = queue.size();
            for (int i = 0; i < size; i += 1){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                //输出x,y坐标
                System.out.println(x + " " + y);
                if (x-1 >= 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    queue.add(new int[]{x-1,y});
                }
                if (x+1 < sum_x && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    queue.add(new int[]{x+1,y});
                }
                if (y-1 >= 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    queue.add(new int[]{x,y-1});
                }
                if (y+1 < sum_y && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    queue.add(new int[]{x,y+1});
                }

            }
            sum++;
            if (queue.size() == 0){
                break;
            }
        }
        for (int i=0;i < grid.length; i += 1){
            for (int j=0;j < grid[0].length; j += 1){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return sum-1;
    }
}