package com.leetcode.NO3075_maximumHappinessSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0;
        int index = 0;
        int n = happiness.length;
        for(int i=0;i<k;i++) {
            int temp = happiness[n-1-i] - index++;
            if (temp <= 0){
                return result;
            }
            result += temp;
        }
        return result;
    }
}