package com.leetcode.NO840_numMagicSquaresInside;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int line = grid.length;
        if (line == 0){
            return 0;
        }
        int row = grid[0].length;
        int sum = 0;
        for(int i=1;i<line-1;i++){
            for(int j=1;j<row-1;j++){
                sum += Judge(grid,i,j);
            }
        }
        return sum;
    }
    public int Judge(int[][] grid, int i,int j){
        Set<Integer> set = new HashSet<>();
        if (grid[i-1][j-1] + grid[i+1][j+1] !=
            grid[i+1][j-1] + grid[i-1][j+1]) {
            return 0;
        }
        int[] rowSum = new int[3];
        for(int x = -1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                if (set.contains(grid[i+x][j+y]) || grid[i+x][j+y]>9 || grid[i+x][j+y] <=0){
                    return 0;
                }
                rowSum[x+1] += grid[i+x][j+y];
                set.add(grid[i+x][j+y]);
            }
        }
        if (rowSum[0]!=rowSum[1] || rowSum[1]!=rowSum[2]){
            return 0;
        }
        int[] lineSum = new int[3];
        for(int y=-1;y<=1;y++){
            for(int x=-1;x<=1;x++){
                lineSum[y+1] += grid[i+x][j+y];
            }
        }
        if (lineSum[0] !=lineSum[1] || lineSum[1] != lineSum[2]){
            return 0;
        }
        return 1;
    }
}