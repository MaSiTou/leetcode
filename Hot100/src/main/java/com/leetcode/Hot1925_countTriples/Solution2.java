package com.leetcode.Hot1925_countTriples;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int countTriples(int n) {
        int count = 0;
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = (int) Math.sqrt(i*i + j*j);
                if( temp <=n && (temp*temp == i*i +j*j)){
                    count++;
                }
            }
        }
        return count*2; // 4 3 5 和 3 4 5都是
    }
}
