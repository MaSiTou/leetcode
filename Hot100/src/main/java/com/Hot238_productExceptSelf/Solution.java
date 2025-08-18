package com.Hot238_productExceptSelf;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //超时了，需要使用别的方法
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (j ==i){
                    continue;
                }
                result[j] = result[j] * nums[i];
            }
        }
        return result;
    }
}
