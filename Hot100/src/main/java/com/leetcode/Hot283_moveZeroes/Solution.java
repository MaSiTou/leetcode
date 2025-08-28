package com.leetcode.Hot283_moveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        //首先定义两个指针，准备循环
        //循环条件是指向非零元素的指针超过了最后一个元素的位置
        int zeroIndex = 0;
        int NonZeroIndex = 0;
        while (true){
            while(NonZeroIndex < nums.length && nums[NonZeroIndex] == 0){
                NonZeroIndex++;
            }
            if (NonZeroIndex >= nums.length){
                break;
            }
            while(zeroIndex < nums.length && nums[zeroIndex] != 0){
                zeroIndex++;
            }
            if(zeroIndex >= nums.length){
                break;
            }
            if (zeroIndex < NonZeroIndex){
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[NonZeroIndex];
                nums[NonZeroIndex] = temp;
            }else{
                NonZeroIndex ++;
            }
        }
    }
}
