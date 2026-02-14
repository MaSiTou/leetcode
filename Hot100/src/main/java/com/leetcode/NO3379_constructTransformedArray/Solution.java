package com.leetcode.NO3379_constructTransformedArray;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for(int i = 0;i < length;i++){
            if (nums[i] > 0){
                result[i] = nums[(i+nums[i])%length];
            }else if (nums[i] < 0){
                result[i] = nums[(length + i - Math.abs(nums[i])%length)%length];
            }else{
                result[i] = nums[i];
            }
        }
        return result;
    }
}