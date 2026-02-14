package com.leetcode.Hot2598_MAX_MEX;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{
                0,0,0,0,1,0,0,1,0,0,1,1,0,1,0,1,1
        };
        Solution solution = new Solution();
        System.out.println(solution.findSmallestInteger(nums,2));
    }
}
