package com.leetcode.NO1266_minTimeToVisitALLPoints;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTimeSum = 0;
        for(int i = 0;i < points.length-1; i++){
            int nowX = points[i][0];
            int nowY = points[i][1];
            int nextX = points[i+1][0];
            int nextY = points[i+1][1];
            int differX = Math.abs(nextX - nowX);
            int differY = Math.abs(nextY - nowY);
            minTimeSum += (Math.max(differY,differX));
        }
        return minTimeSum;
    }
}