package com.Hot1_twoSum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //将Int数组转换为Integer数组

       for (int i = 0; i < nums.length; i++){
           for (int j = i+1; j < nums.length; j++){
               if (nums[i] + nums[j] == target){
                   return new int[]{i,j};
               }
           }
       }
       return null;
    }
}