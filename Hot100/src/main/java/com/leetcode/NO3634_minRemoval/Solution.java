package com.leetcode.NO3634_minRemoval;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minRemoval(int[] nums, int k) {
//        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr,Collections.reverseOrder());
//        nums = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
//        int length = nums.length;
//        int result = length-1;
//        for(int i = 0;i < length;i++){
//            int j = length-1;
//            while(i < j && (long)nums[j]*k < nums[i]){
//                j--;
//            }
//            result = Math.min(result,length-1-j+i);
//        }
//        return result;
        Arrays.sort(nums);
        int length = nums.length;
        int result = length-1;
        int j = 0;
        for(int i = 0;i < length; i++){
            while(j < length && (long)nums[i]*k >= nums[j]){
                j++;
            }
            result = Math.min(result,length-1-j+i);
        }
        return result;
    }
}