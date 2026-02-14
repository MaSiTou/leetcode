package com.leetcode.NO1390_sumFourDivisors;

/**
 * 使用的是题目给定的10000的界限，计算里面所有的元素的因数
 */
public class Solution2 {
    static int NX = 100001;
    public int sumFourDivisors(int[] nums){
        int[] divisorNum = new int[NX];
        int[] divisorSum = new int[NX];
        int result = 0;
        for(int i=1;i<NX;i++){
            for(int j = i;j<NX;j+=i){
                divisorNum[j] ++ ;
                divisorSum[j] += i;
            }
        }
        for(int num:nums){
            if (divisorNum[num] == 4){
                result += divisorSum[num];
            }
        }
        return result;
    }
}
