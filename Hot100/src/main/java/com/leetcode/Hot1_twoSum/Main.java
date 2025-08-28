package com.leetcode.Hot1_twoSum;

public class Main {
    public static void main(String[] args) {
        Solution_best solution = new Solution_best();
        int[] nums =solution.twoSum(new int[]{2,7,11,15},9);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
