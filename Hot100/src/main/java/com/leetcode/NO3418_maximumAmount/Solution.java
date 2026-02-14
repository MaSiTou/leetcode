package com.leetcode.NO3418_maximumAmount;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历，只能向右或者向下走，统计所有可能的走法，同时，出现负值记录，找出最小（绝对值最大）的两个置为0
 */
class Solution {
    int SPECIAL_NUMBER = 2;
//    public int maximumAmount(int[][] coins) {
//
//    }
//
//    public int dfs(int[][] coins, int x, int y, List<Integer> list)  {
//        if (x <0 || x >= coins.length || y <0 || y >= coins[0].length){
//            return 0;
//        }
//        if (coins[x][y] < 0){
//            list.add(coins[x][y]);
//        }
//        if (x == coins.length-1 && y == coins[0].length-1){
//            return 0;
//        }
//        int right = dfs(coins,x,y+1,list);
//        for(int i:list){
//
//        }
//        list = new ArrayList<>();
//        int down = dfs(coins,x+1,y,list);
//        for(int i:list){
//
//        }
//        list = new ArrayList<>();
//        return right+down+ (Math.max(coins[x][y], 0));
//    }
}