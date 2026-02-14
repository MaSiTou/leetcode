package com.leetcode.NO3562_maxProfit;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 2;
        int[] present = {1,2};
        int[] future = {4,3};
        int[][] hierarchy = new int[][]{{1,2}};
        int budget = 3;
        s.maxProfit(n,present,future,hierarchy,budget);
    }
}
