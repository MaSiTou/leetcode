package com.leetcode.NO1975_maxMatrixSum;

/**
 * 脑筋急转弯啊。统计负数出现的次数就可以
 */
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minNum = Math.abs(matrix[0][0]);
        long sumNums = 0;
        int negativeNum = 0;
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sumNums += Math.abs(matrix[i][j]);
                if (Math.abs(matrix[i][j]) < minNum){
                    minNum = Math.abs(matrix[i][j]);
                }
                if (matrix[i][j] < 0){
                    negativeNum ++;
                }
            }
        }
        if (negativeNum % 2 == 0){
            return sumNums;
        }else{
            return sumNums - 2*minNum;
        }
    }
}