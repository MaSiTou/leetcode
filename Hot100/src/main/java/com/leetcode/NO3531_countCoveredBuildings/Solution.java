package com.leetcode.NO3531_countCoveredBuildings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！
 * 超时！！！！！！
 */
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int ans = 0;
        //思路还是复杂了，不想动脑子，就想着怎么简单怎么来
        //转换为二维数组，1是有building，0是没有building
        int[][] map = new int[n][n];
        for(int i=0;i<buildings.length;i++){
            map[buildings[i][1]-1][buildings[i][0]-1] = 1;
        }
        //先按照列遍历,保存每一列的行的最小和最大，为了后续的行遍历，保存到row[n][2]，n是列，2是行
        int[][] rowOne = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(rowOne[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (map[j][i] == 1){
                    if(rowOne[i][0] == -1){
                        rowOne[i][0] = j;
                    }else {
                        rowOne[i][1] = j;
                    }
                }

            }
            System.out.println(i+" " +rowOne[i][0] + " " + rowOne[i][1]);
        }
        //按照行遍历，每一行的1保存到List<Integer>中，去除首尾，遍历这个list。
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    list.add(j);
                }
            }
            if(list.size()>=2){
                list.removeFirst();
                list.removeLast();
            }else{
                continue;
            }
            for(Integer row:list){
                System.out.println(i + " " + row);
                System.out.println(rowOne[row][0] + " " + rowOne[row][1]);
                if (i > rowOne[row][0] && i < rowOne[row][1]){
                    ans++;
                }
            }
        }
        return ans;
    }
}