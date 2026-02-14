package com.leetcode.NO1458_maxDotProduct;

/**
 *动态规划题目
 */
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (i == 0 && j ==0){
                    dp[i][j] = nums1[i] * nums2[j];
                }else if (i == 0){
                    dp[i][j] = Math.max(dp[i][j-1],nums1[i]*nums2[j]);
                }else if (j == 0){
                    dp[i][j] = Math.max(dp[i-1][j],nums1[i]*nums2[j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+nums1[i]*nums2[j],Math.max(dp[i-1][j],Math.max(dp[i][j-1],nums1[i] * nums2[j])));
                }
            }
        }
        return dp[n-1][m-1];
    }
}