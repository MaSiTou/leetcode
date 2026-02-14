package com.leetcode.NO3650_minCost;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] edges = new int[][]{
                {1,0,7},
                {1,2,10},
                {0,1,15},
                {0,2,4},
        };
        int minCost = solution.minCost(n, edges);
        System.out.println(minCost);
    }
}
