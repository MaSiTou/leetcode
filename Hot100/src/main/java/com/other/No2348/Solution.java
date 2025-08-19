package com.other.No2348;

//全0子数组的数目
public class Solution {
    public long zeroFilledSubarray(int[] nums){
        long i=-1,j=0;
        long num_zeros = 0;
        for (;j<nums.length;j++){
            if (nums[(int) j] != 0){
                num_zeros += (j- i - 1)*(j-i)/2;
                i=j;
            }
        }
        if (i!=j){
            num_zeros +=(j- i - 1)*(j-i)/2;
        }
        return num_zeros;
    }
}
