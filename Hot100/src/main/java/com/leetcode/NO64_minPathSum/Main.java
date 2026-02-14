package com.leetcode.NO64_minPathSum;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1},
        };
        System.out.println(s.minPathSum(grid));;
    }
}
