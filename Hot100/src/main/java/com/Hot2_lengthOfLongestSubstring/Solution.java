package com.Hot2_lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s){
        int max = 0;
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        while(i<s.length() && j < s.length()){
            char temp = s.charAt(j);
            if (set.contains(temp)){
                i = i+1;
                j=i;
                set.clear();
            }
            else{
                set.add(temp);
                j++;
                max = Math.max(max,j-i);
            }
        }
        return max;
    }
}
