package com.leetcode.NO712_minimumDeleteSum;

/**
 * 该题目类似于最长公共子序列
 * 动态规划
 * 考虑边界条件
 * 考虑公式
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp=  new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            int code1=0;
            if (i > 0) {
                code1 = s1.charAt(i-1);
            }
            for(int j=0;j<=n;j++){
                int code2=0 ;
                if (j > 0){
                    code2 = s2.charAt(j-1);
                }
                if (i ==0 && j==0){
                    dp[i][j] = 0;
                }else if(i == 0 && j >=1){
                    dp[i][j] = dp[i][j-1] + code2;
                }else if(j==0 && i >=1){
                    dp[i][j] = dp[i-1][j] + code1;
                }else{
                    if (code2 == code1){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(dp[i][j-1]+code2,dp[i-1][j]+code1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}