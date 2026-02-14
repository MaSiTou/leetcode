package com.leetcode.NO2110_getDescentPeriods;


/**
 * b数据量非常大，不要忘记使用long类型
 */
class Solution {
    public long getDescentPeriods(int[] prices) {
        int i=0;
        int n = prices.length;
        long ans = 0;
        while(i<n){
            int j=i+1;
            while(j < n && prices[j] == prices[j-1]-1){
                j++;
            }
            System.out.println("j:" + j + "i: " + i);
            ans += ((long) (j - i + 1) *(j-i) / 2);
            i = j;
        }
        return ans;
    }
}