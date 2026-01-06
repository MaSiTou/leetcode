package com.leetcode.NO1292_maxSideLength;

/**
 * dp[m-1][n-1][]表示从[i,j]到[m-1,n-1]的满足条件的最大正方形的长度以及
 * 长m-1,宽n-1
 * 从[m-1,n-1]遍历，
 * i==m-1 || j==n-1时：
 *          判断cat[i][j]与threshold的值，更新dp[i][j][]
 * 否则，考虑cat[i][j]与threashold的值，
 *            小于threashold，如果dp[i-1][j-1]为0，dp[i][j][] = 0;
 *                           否则，cat[i-1][j]+cat[i][j-1]+cat[i][j]+dp[i-1][j-1][1] 小于threshold dp[i][j][0]++, dp[i][j][1] = cat[i-1][j]+cat[i][j-1]+cat[i][j]
 *            大于，dp[i][j][0] = 0;
 *  上述过程记录dp[i][j][0]的最大值为结果
 */
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int[][] dpSum = new int[m+1][n+1];
        int result = 0;
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j >=0;j --){
                if (i == m-1 || j == n-1){
                    dpSum[i][j] = mat[i][j] + (i==m-1? dpSum[i][j+1] : dpSum[i+1][j]);
                    if (mat[i][j] <= threshold){
                        dp[i][j] = 1;
                        result = Math.max(dp[i][j],result);
                    }else{
                        dp[i][j] = 0;
                    }
                }else{
                    dpSum[i][j] = mat[i][j] + dpSum[i+1][j]-dpSum[i+1][j+1]  + dpSum[i][j+1];
                    if (mat[i][j] <= threshold){
                        int L = dp[i+1][j+1];
                        int tempSum=0;
                        /*
                        忘记考虑了一种情况，就是
                        1 2 3
                        4 5 6
                        7 8 9
                        中如果
                        5 6
                        8 9
                        不满足情况
                        那么
                        1 2 3
                        4 5 6
                        7 8 9
                        不一定组不成满足条件的正方形，可以考虑
                        1 2
                        4 5
                         */
                        do{
                            int y = j + L + 1;
                            int x = i + L + 1;
                            tempSum = dpSum[i][j]-dpSum[i][y] - (dpSum[x][j] - dpSum[x][y]);
                            L--;
                        }while(tempSum>threshold && L>=0);
                        if (L < 0){
                            dp[i][j] = 1;
                            result = Math.max(result,dp[i][j]);
                        }else{
                            dp[i][j] = L + 1;
                            result = Math.max(result,dp[i][j]);
                        }
                    }
                }
            }
        }
        return result;
    }
}