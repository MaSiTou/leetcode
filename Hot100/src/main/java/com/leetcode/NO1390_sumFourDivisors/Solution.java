package com.leetcode.NO1390_sumFourDivisors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if (map.containsKey(num)){
                result += map.get(num);
                continue;
            }
            Set<Integer> AllDivisors = new HashSet<>();
            for(int i = 1;i <= num;i++){
                if (num % i == 0){
                    AllDivisors.add(i);
                }
                if (AllDivisors.size() > 4){
                    break;
                }
            }
            if (AllDivisors.size() == 4){
                int temp = 0;
                for(int divisor:AllDivisors){
                    temp += divisor;
                }
                result += temp;
                map.put(num,temp);
            }
        }
        return  result;
    }
}