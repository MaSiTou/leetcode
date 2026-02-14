package com.leetcode.NO2976_minimumCost;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 弗洛伊德算法，可以求出任一点到任一点的最短的距离
 * dp[i][j[k] 表示的是从i到j，中转点小于等于k的最短的距离
 * 实际上是一个dp问题
 * dp[i][j][k] = Min(dp[i-1][j][k],dp[i-1][j][i]+dp[i-1][i][k])
 * 用二维表示，dp[j][k]本身就是i-1时候的从j到k的最短距离，也就是dp[i-1][j][k]
 */
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] changedMinCost = new int[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(changedMinCost[i],Integer.MAX_VALUE);
        }
        long result = 0;
        for(int i = 0;i< cost.length;i++){
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            changedMinCost[x][y] = Math.min(cost[i],changedMinCost[x][y]);
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                for(int k=0;k<26;k++){
                    if (j == k || changedMinCost[j][i] == Integer.MAX_VALUE || changedMinCost[i][k] == Integer.MAX_VALUE){
                        continue;
                    }
                    changedMinCost[j][k] = Math.min(changedMinCost[j][k],changedMinCost[j][i]+changedMinCost[i][k]);
                }
            }
        }
        for(int i=0;i<source.length();i++){
            int x = source.charAt(i) - 'a';
            int y = target.charAt(i) - 'a';
//            System.out.println(x + " " + y);
            if (x != y ) {
                if (changedMinCost[x][y] != Integer.MAX_VALUE){
                    result += changedMinCost[x][y];
                }else{
                    return -1;
                }
            }
        }
        return result;
    }
}