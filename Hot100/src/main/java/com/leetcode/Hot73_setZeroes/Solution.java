package com.leetcode.Hot73_setZeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        //使用两个一维数组记录
        //一个记录每一行是否是有零，
        //另一个记录每一列是否是有零
        int[] row = new int[matrix.length];
        int[] line = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("元素："+matrix[i][j]);
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    line[j] = 1;
                    System.out.println("有0");
                }
            }
        }
        for (int r : row) {
            System.out.println(r);
        }
        for (int l : line) {
            System.out.println(l);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]==1) {
                for (int j=0;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (line[i]==1) {
                for (int j=0;j<matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
