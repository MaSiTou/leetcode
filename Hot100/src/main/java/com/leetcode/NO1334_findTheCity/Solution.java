package com.leetcode.NO1334_findTheCity;

import java.util.Arrays;

/**
 * 首先找到任一点到任一点的最短距离
 * 遍历任一点的小于阈值的个数，找到当前个数最小的点，如果个数有相同的，选择编号最大的
 */
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i = 0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int cost = edges[i][2];
            dist[from][to] = cost;//因为没有相同的from和to
            dist[to][from] = cost;
        }
        for(int k = 0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (i == j || dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+ dist[k][j]);
                }
            }
        }
        int resultNumber = Integer.MAX_VALUE;
        int resultIndex = -1;
        for(int i = 0;i < n;i++){
            int BelowThresholdNumber = 0;
            for(int j=0;j < n;j++){
                if (i == j || dist[i][j] == Integer.MAX_VALUE){
                    continue;
                }
                System.out.print(dist[i][j]+" ");
                if (dist[i][j] <= distanceThreshold){
                    BelowThresholdNumber++;
                }
            }
            if (BelowThresholdNumber <= resultNumber){
                resultNumber = BelowThresholdNumber;
                resultIndex = i;
            }
            System.out.println();
        }
        return resultIndex;
    }
}