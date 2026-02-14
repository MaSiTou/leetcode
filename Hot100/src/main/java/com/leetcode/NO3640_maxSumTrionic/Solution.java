package com.leetcode.NO3640_maxSumTrionic;


/**
 * 遍历数组，使用大小为3的数组记录四组数据。以环的形式体现
 * 当下一个点比当前点大的时候，如果数据下标是1，需要记录严格递增这一段的以最后一个点为终点的最大值。
 * 如果数据下标是0，需要记录严格递增这一段的以第一个点为起点的最大值。
 * 当下一个点比当前点小的时候，
 *
 */
class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        long result = Long.MIN_VALUE;
        while(i+1<n){
            int begin = i;
            long tempSumIncrease1 = 0;
            while(i+1<n && nums[i+1] > nums[i]){
                if (nums[i+1] <0){
                }else{
                    tempSumIncrease1+=nums[i+1];
                }
                i++;
            }
            if (begin == i){
                i++;
                continue;
            }
            if (tempSumIncrease1 == nums[i] && nums[i-1]<0){
                tempSumIncrease1+=nums[i-1];
            }
            if (nums[begin] >0){
                tempSumIncrease1 += nums[begin];
            }
            if (nums[i] < 0){
                tempSumIncrease1 = nums[i] + nums[i-1];
            }
            long tempSumDecrease = 0;
            begin = i;
            while(i+1<n && nums[i+1] < nums[i]){
                tempSumDecrease+=nums[i+1];
                i++;
            }
            if (begin==i){
                i++;
                continue;
            }
            long tempSumIncrease2 = 0;
            begin = i;
            while(i+1 < n && nums[i+1] > nums[i]){
                tempSumIncrease2+=nums[i+1];
                i++;
            }
            if (begin == i){
                i++;
                continue;
            }
            tempSumIncrease2 = Math.max(tempSumIncrease2, nums[begin+1]);
            result = Math.max(result,tempSumIncrease2+tempSumDecrease+tempSumIncrease1);
            i = begin;
        }
        return result;
    }
}