package com.leetcode.NO1351_countNegatives;

class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int i = n-1;
        int j = 0;
        int sum = n+m;
        int result = 0;
        while(sum >= 0){
            if (i < 0 || j >= m){
                break;
            }
            sum--;
            if (grid[j][i] < 0){
                result += (m-j);
                i--;
                continue;
            }
            if (grid[j][i] >= 0){
                j++;
            }
        }
        return result;
    }
}