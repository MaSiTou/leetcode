package com.leetcode.NO123_maxProfit;

/**
 * 限制购买最多次数为2，这个题，给我的感觉就是和接雨水类似的一个题目
 *
 * 总体思路就是以当前位置为一个标志，计算左边的最大利润，右边的最大利润，加起来计算总的最大利润
 *
 * 此种思路方法正确，但是超时，方法的时间复杂度是O(n*2)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int leftProfit=0;
        int rightProfit=0;
        for(int i=1;i<prices.length;i++){
            leftProfit = 0;
            int leftMinPrice = prices[0];
            for(int left = 1;left <= i;left++){
                leftProfit = Math.max(leftProfit,prices[left]-leftMinPrice);
                leftMinPrice = Math.min(prices[left],leftMinPrice);
            }
            rightProfit = 0;
            int rightMinPrice = prices[i];
            for(int right = i+1;right < prices.length;right++)
            {
                rightProfit = Math.max(rightProfit,prices[right]-rightMinPrice);
                rightMinPrice = Math.min(prices[right],rightMinPrice);
            }
            result = Math.max(result,leftProfit+rightProfit);
        }
        return result;
    }
}