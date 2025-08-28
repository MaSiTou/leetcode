package com.leetcode.Hot322_coinChange;

public class Solution {
    public int coinChange(int[] coins,int amount){
        int[] dp = new int[amount];//默认是0, dp[i]代表的是i最少的硬币个数
        //dp[i] = 遍历j,得到最小的dp[i-coins[j]] + 1
        for (int i=0;i<amount;i++){

            for (int j=0;j<coins.length;j++){
                int min = coins[0];
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i-coins[j]],min) + 1;
                }
            }
        }
        return dp[amount];
    }
}
