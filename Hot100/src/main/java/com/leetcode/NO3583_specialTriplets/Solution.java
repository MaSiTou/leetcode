package com.leetcode.NO3583_specialTriplets;

/**
 * 简单答案，超时
 */
class Solution {
    public int specialTriplets(int[] nums) {
        long count=0;
        for(int i=0;i<nums.length;i++){
            for(int k=nums.length-1;k>=i;k--){
                if(nums[i] == nums[k]){
                    for(int j = i+1;j<k;j++){
                        if(nums[j] *2 == nums[i]){
                            count++;
                        }
                    }
                }
            }
        }
        return (int) ((int)count % (10e9+7));
    }
}