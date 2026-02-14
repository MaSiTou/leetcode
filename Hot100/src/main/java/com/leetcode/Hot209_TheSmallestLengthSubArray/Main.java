package com.leetcode.Hot209_TheSmallestLengthSubArray;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
            1,2,3,4,5
        };
        int target = 11;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
