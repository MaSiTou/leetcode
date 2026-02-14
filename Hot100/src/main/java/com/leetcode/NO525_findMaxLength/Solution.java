package com.leetcode.NO525_findMaxLength;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int counter = 0;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i < nums.length; i++){
            nums[i] = nums[i]==0?-1:1;
            if (nums[i] == -1){
                counter--;
            }else{
                counter++;
            }
            if(map.containsKey(counter)){
                int index = map.get(counter);
                result = Math.max(result,i-index);
            }else{
                map.put(counter,i);
            }
        }
        return result;
    }
}