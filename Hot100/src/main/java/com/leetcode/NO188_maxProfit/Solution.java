package com.leetcode.NO188_maxProfit;

/**
 * 总体来说，某一天的最大利润，应该是前一天卖掉之前的最大利润或者是前一天买股票的最大利润加上当前天的卖出赚的钱（可以加上一个限制条件，恰好买k次）
 * 不妨设置买和卖，分别使用两个数组表示。
 * 第一个数组buy[i][k],表示第i天持有股票恰好买卖k次的最大利润。
 * 第二个数组sell[j][k],表示第j天不持有股票恰好买卖k次的最大利润。
 * 列出状态转移方程：
 * buy[i][k] = Math.max(buy[i-1][k],sell[i-1][k]-prices[i])
 * sell[i][k] = Math.max(sell[i-1][k],buy[i-1][k-1]+prices[i])
 *
 * 理论上最后一天不持有股票的利润最大
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] buy = new int[prices.length][k+1];
        int[][] sell = new int[prices.length][k+1];
        buy[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j]-prices[i]);
                sell[i][j] = Math.max(sell[i-1][j],buy[i-1][j-1]+prices[i]);
            }
            System.out.println(sell[i][k]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<prices.length;i++){
            ans = Math.max(ans,sell[i][k]);
        }
        return ans;
    }
}