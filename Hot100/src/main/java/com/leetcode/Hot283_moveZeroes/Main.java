package com.leetcode.Hot283_moveZeroes;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
