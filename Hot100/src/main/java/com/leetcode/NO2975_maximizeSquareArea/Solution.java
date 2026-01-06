package com.leetcode.NO2975_maximizeSquareArea;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 记录HFences的所有的连续和，还要排序，从大到小。
 * 然后从VFences获得的所有的连续和，不需要排序，遍历HFences中的所有的看
 */
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        int HLength = hFences.length;
        int VLength = vFences.length;
        int[] HDiffer = new int[HLength+1];
        int[] VDiffer = new int[VLength+1];
        Set<Long> set = new HashSet<>();
        for(int i=0;i<HLength+1;i++){
            if (i == 0){
                HDiffer[i] = hFences[i] - 1;
//                AllHDifferSum[i][i] = HDiffer[i];
            }else if (i != HLength){
                HDiffer[i] = hFences[i]- hFences[i-1];
            }else{
                HDiffer[i] = m - hFences[i-1];
            }
            long tempArea = HDiffer[i];
            set.add(tempArea);
            for(int k=i-1;k>=0;k--){
                tempArea += HDiffer[k];
                set.add(tempArea);
            }
        }
        long tempMaxArea = -1;
        for(int i=0;i<VLength+1;i++){
            if (i==0){
                VDiffer[i] = vFences[i] - 1;
            }else if (i != VLength){
                VDiffer[i] = vFences[i] - vFences[i-1];
            }else{
                VDiffer[i] = n - vFences[i-1];
            }
            long tempArea = VDiffer[i];
            if (set.contains(tempArea) && tempArea > tempMaxArea){
                tempMaxArea = tempArea;
            }
            for(int k=i-1;k>=0;k--){
                tempArea += VDiffer[k];
                if (set.contains(tempArea) && tempArea > tempMaxArea){
                    tempMaxArea = tempArea;
                }
            }
        }
        if (tempMaxArea == -1){
            return -1;
        }else{
            return (int)(tempMaxArea*tempMaxArea % 1_000_000_007);
        }
    }
}