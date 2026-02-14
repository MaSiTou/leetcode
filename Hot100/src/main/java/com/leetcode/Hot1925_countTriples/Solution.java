package com.leetcode.Hot1925_countTriples;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countTriples(int n) {
        int count=0;
        Set<Integer> set = new HashSet<>();
        for (int i =1;i <=n;i++){
            set.add(i*i);
        }
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(set.contains(i*i+j*j)){
                    System.out.println(i +" " +j);
                    count++;
                }
            }
        }
        return count*2; // 4 3 5 和 3 4 5都是
    }
}