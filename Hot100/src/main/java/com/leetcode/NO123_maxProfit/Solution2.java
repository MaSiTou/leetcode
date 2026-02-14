package com.leetcode.NO123_maxProfit;


/**
 *此种思
 */
public class Solution2 {
    public int maxProfit(int[] prices){
        int ans = 0;
        int[] leftProfit = new int[prices.length];
        int leftMinPrice = prices[0];

        for(int i=1;i<prices.length;i++){
            leftProfit[i] = Math.max(leftProfit[i-1],prices[i] - leftMinPrice);
            leftMinPrice = Math.min(leftMinPrice,prices[i]);
        }
        int[] rightProfit = new int[prices.length];
        int rightMaxPrice = prices[prices.length-1];
        for(int j = prices.length-2;j>-1;j--){
            rightProfit[j] = Math.max(rightProfit[j+1],rightMaxPrice - prices[j]);
            ans = Math.max(ans,leftProfit[j] + rightProfit[j]);
            rightMaxPrice = Math.max(rightMaxPrice,prices[j]);
        }
        return ans;
    }
}
