package com.leetcode.NO3453_separateSquares;

import java.util.*;

/**
 * 大量正方形，首先，抽象成面积，现在，考虑y和面积进行查找
 * 计算总面积，查找目标就是总面积/2
 * y只考虑左上角
 * y从小到打排序，从小到大开始，找到一个接近总面积/2的。
 * 只有两种情况，第一种，在外面，肯定是左上角；第二种情况，在内部
 */
class Solution {
    public double separateSquares(int[][] squares) {
        long allArea = 0 ;
        Map<Long,Long> map = new TreeMap<>();
        for(int[] square:squares){
            long temp = square[2];
            map.merge((long) square[1],temp,Long::sum);
            map.merge(square[1]+temp,-temp,Long::sum);
            allArea += temp*temp;
        }
        long tempArea = 0;
        long lastY = 0;
        int L = 0;
        for(Map.Entry<Long,Long> entry:map.entrySet()){
            tempArea += L * (entry.getKey() - lastY);
            if (2*tempArea >= allArea){
                return entry.getKey() - (double) (2 * tempArea - allArea) / (2 * L);
            }

            lastY = entry.getKey();
            L += entry.getValue();
        }
        return -1;
    }
}