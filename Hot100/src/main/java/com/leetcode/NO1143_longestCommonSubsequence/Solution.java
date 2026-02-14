package com.leetcode.NO1143_longestCommonSubsequence;


/**
 * 解题思路：
 * 1.数据结构定义：
 *  n = text1.length()
 *  m = text2.length()
 *  dp[i][j]表示text1[0……i] 和text2[0……j]两个字符串的最长公共子序列的长度
 * 2.边界条件
 *  dp[0][0] = 0
 *  dp[o][j],其中0<=j<=m
 *  dp[i][0],其中0<=i<=n
 *  当i!=0 && j!=0 时，
 *      此时，text1[i] == text2[j],显而易见，dp[i][j] = dp[i-1][j-1] + 1;
 *      否则，dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]),为什么不考虑dp[i-1][j-1]?因为dp[i-1][j]或者说
 *   dp[i][j-1] 它的含义就是text1[0…i],text2[0……j-1]的LCS，已经包含了dp[i-1][j-1]
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }else {
                    if (text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}