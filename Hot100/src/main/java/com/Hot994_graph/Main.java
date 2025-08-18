package com.Hot994_graph;

public class Main {
    public static void main(String[] args) {
        //二维数组初始化，长度是3，宽度是4
        int[][] grid = {
                {0,1,2,0},
                {2,0,1,2},
                {1,2,0,1}
        };
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));
    }
}
