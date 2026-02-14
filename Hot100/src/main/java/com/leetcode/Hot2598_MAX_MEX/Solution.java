package com.leetcode.Hot2598_MAX_MEX;

import java.util.HashSet;
import java.util.*;

public class Solution {
    public int findSmallestInteger(int[] nums, int value) {
//        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = getMEX(nums[i], value);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int start = 0;
//        while(set.contains(start)){
//            start++;
//        }
        int EndStart = 0;
        while(true){
            if (map.containsKey(start)){
                if (map.get(start) >0){
                    map.put(start,map.get(start)-1);
                    start++;
                }else{
                    return EndStart;
                }
            }else{
                if (start < value){
                    return start;
                }else{
                    EndStart += start;
                    start =1;
                }
            }
        }
    }
    public int getMEX(int num,int value){
        num += value * (Math.abs(num) / value + 1);
        return num - value * (num / value);
    }
}
