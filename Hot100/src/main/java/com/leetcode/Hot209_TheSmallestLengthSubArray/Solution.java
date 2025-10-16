package com.leetcode.Hot209_TheSmallestLengthSubArray;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int result = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for(int i=0;i<length;i++){
            result += nums[i];
            while(result>=target){
                if ((i-j +1) < min) min = (i-j+1);
                result -= nums[j];
                j++;
            }
        }
        return min!=Integer.MAX_VALUE?min:0;
    }
}
