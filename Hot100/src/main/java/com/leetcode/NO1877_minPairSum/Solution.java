package com.leetcode.NO1877_minPairSum;

import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int result = 0;
        for(int i=0;i<= n;i++){
            result = Math.max(result,nums[i]+nums[n-i]);
        }
        return result;
    }
}