package com.leetcode.NO3719_longestBalanced;

import java.util.HashSet;
import java.util.Set;


class Solution {
    public int longestBalanced(int[] nums) {
        int result = 0;
        for(int i = 0;i < nums.length;i++){
            Set<Integer> oddset = new HashSet<>();
            Set<Integer> evenset = new HashSet<>();
            for(int j=i;j < nums.length;j++){
                if (nums[j] % 2 == 0){
                    evenset.add(nums[j]);
                }else{
                    oddset.add(nums[j]);
                }
                if ( evenset.size() == oddset.size()){
                    result = Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }
}