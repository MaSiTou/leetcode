package com.leetcode.NO2840_checkStrings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[][] s1_cache = new int[2][26];
        int[][] s2_cache = new int[2][26];
        for(int i = 0;i < s1.length();i++){
            if (i % 2 == 0){
                s1_cache[0][s1.charAt(i)-'a']++;
            }else{
                s1_cache[1][s1.charAt(i)-'a']++;
            }
        }
        for(int i = 0;i < s2.length();i++){
            if (i %2 ==0){
                s2_cache[0][s2.charAt(i)-'a']++;
            }else{
                s2_cache[1][s2.charAt(i)-'a']++;
            }
        }
        for(int i = 0;i < 26;i++){
            if ((s1_cache[0][i] != s2_cache[0][i]) ||( s1_cache[1][i] != s2_cache[1][i])){
                return false;
            }
        }
        return true;
    }
}