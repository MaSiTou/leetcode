package com.leetcode.NO3314_minBitwiseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=1;i<=1000;i++){
           int OrSum = i | (i+1) ;
           if (!map.containsKey(OrSum)){
                map.put(OrSum,i);
           }
       }
       List<Integer> list = new ArrayList<>();
       for(int num:nums){
           list.add(map.getOrDefault(num, -1));
       }
       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}