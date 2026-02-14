package com.leetcode.NO3531_countCoveredBuildings;

import java.util.Arrays;

public class Solution2 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans=0;
        //当前列的最大和最小的行
        int[] MIN_Line = new int[n];
        int[] MAX_Line = new int[n];
        Arrays.fill(MIN_Line,-1);
        Arrays.fill(MAX_Line,-1);
        //当前行的最大和最小的列
        int[] MIN_Row = new int[n];
        int[] MAX_Row = new int[n];
        Arrays.fill(MIN_Row,-1);
        Arrays.fill(MAX_Row,-1);
        //开始记录MIN_MAX_Line和MIN_MAX_Row的值
        for (int[] ints : buildings) {
            int nowLine = ints[1]-1;
            int nowRow = ints[0]-1;
            MIN_Line[nowRow] = Math.min(MIN_Line[nowRow]== -1 ?nowLine:MIN_Line[nowRow],nowLine);
            MAX_Line[nowRow] = Math.max(MAX_Line[nowRow]== -1 ?nowLine:MAX_Line[nowRow],nowLine);
            System.out.print(nowRow + " " + MIN_Line[nowRow]  + " " + MAX_Line[nowRow] + " ");
            MIN_Row[nowLine] = Math.min(MIN_Row[nowLine] == -1 ?nowRow:MIN_Row[nowLine],nowRow);
            MAX_Row[nowLine] = Math.max(MAX_Row[nowLine]== -1 ?nowRow:MAX_Row[nowLine],nowRow);
            System.out.println(nowLine + " " + MIN_Row[nowLine] + " " + MAX_Row[nowLine] + " ");
        }
        //查看满足条件的，记录下来
        for (int[] building : buildings) {
            int nowLine = building[1]-1;
            int nowRow = building[0]-1;
            if(MIN_Line[nowRow] == -1 || MAX_Line[nowRow] == -1
                ){
                continue;
            }
            if(MIN_Row[nowLine] == -1 || MAX_Row[nowLine] == -1){
                continue;
            }
            if (nowLine > MIN_Line[nowRow] && nowLine < MAX_Line[nowRow]
                    && nowRow > MIN_Row[nowLine] && nowRow < MAX_Row[nowLine]) {
                ans++;
            }
        }
        return ans;
    }
}
