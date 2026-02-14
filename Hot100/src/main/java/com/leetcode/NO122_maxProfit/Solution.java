package com.leetcode.NO122_maxProfit;


// 没做出来，思路分析
/**
 * 不限制购买的次数，这样的话，我先假如从第i天购买，第j天卖出，如果整个prices数组是线性上升或者线性下降，都好说，但是如果中间从i到k是上升，从K+1到j是上升，但是
 * 从k到k+1是下降，这样的话prices[k] - prices[i] + prices[j] - prices[k+1] 是大于prices[j]-prices[i]的，也就是，贪心
 */
class Solution {
    public int maxProfit(int[] prices) {
        int nowPrice = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            int nowProfit = prices[i] - nowPrice;
            if (nowProfit > maxProfit){
                maxProfit += nowProfit;
            }else{
                nowPrice = prices[i];
            }
        }
        return  maxProfit;
    }
}