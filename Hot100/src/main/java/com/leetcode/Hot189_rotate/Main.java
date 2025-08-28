package com.leetcode.Hot189_rotate;


public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        s.rotate(nums,3);
        for (int n:nums){
            System.out.print(n);
        }
    }
}
