package com.leetcode.NO3562_maxProfit;

class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        int[][] x_to_y_cost = new int[n][n];
        int[][] x_to_y_profit = new int[n][n];
        int k = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(k < hierarchy.length && i == hierarchy[k][0]-1 && j == hierarchy[k][1]-1){
                    x_to_y_cost[i][j] = present[i] + Math.floorDiv(present[j],2);
                    x_to_y_profit[i][j] = future[i] - present[i] + future[j] - Math.floorDiv(present[j],2);
                    k++;
                }else{
                    x_to_y_cost[i][j] = i==j?present[i]:present[i]+present[j];
                    x_to_y_profit[i][j] = i==j?future[i]-present[j] : future[i] - present[i] + future[j] - present[j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(x_to_y_cost[i][j] + " ");
            }
            for(int j=0;j<n;j++){
                System.out.print(x_to_y_profit[i][j] + " ");
            }
            System.out.println();
        }

        return 1;
    }

}