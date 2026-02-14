package com.leetcode.NO3637_isTrionic;

class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0;
        int n = nums.length-1;
        int begin_i = 0;
        while(i+1 <=n && nums[i+1] > nums[i]){
            i++;
        }
        if (begin_i == i){
            return false;
        }
        begin_i = i;
        while(i+1 <= n && nums[i+1] < nums[i]){
            i++;
        }
        if (begin_i == i){
            return false;
        }
        begin_i = i;
        while(i+1 <= n && nums[i+1] > nums[i]){
            i++;
        }
        if (begin_i == i || i !=n){
            return false;
        }
        return true;
    }
}