package com.leetcode.NO3573_maximumProfit;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        //从i到j的可能的最大利润
        //profit[i][j] = max(profit[i][j-1],prices[j]-profit[i],for(k=i;k<j;k++):max(profit[i][k]+prices[j] - prices[k+1]))
        long[][] profit = new long[n][n];
        for(int i=0;i<n;i++){
            for(int j =i;j<n-1;j++){
                if(i == j) profit[i][j] = 0;
                int i_to_j_profit = prices[j+1] - prices[i];
//                profit
            }
        }
        return 1L;
    }
}