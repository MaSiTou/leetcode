package com.leetcode.NO3557_countPermutations;

class Solution {
    public int countPermutations(int[] complexity) {
        int base = complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(complexity[i] <= base){
                return 0;
            }
        }
        long result = 1;
        long MOD = 1_000_000_007;
        for(int i=2;i<= (complexity.length-1);i++){
            result *= i;
            result = result % MOD;
        }
        return (int) (result % MOD);
    }
}