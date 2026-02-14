package com.leetcode.No2839_canbeEqual;

class Solution {
    public boolean canBeEqual(String s1, String s2) {
        for(int i = 0;i<4;i++){
            if (s1.charAt(i) == s2.charAt(i)){
            }else{
                int j = i + 2;
                while(j < 4 && s1.charAt(i) != s2.charAt(j)){
                    j = j + 2;
                }
                if (j >= 4){
                    return false;
                }else{
                    char temp = s2.charAt(i);
                    s2 = s2.substring(0,i) + s2.charAt(j) + s2.substring(i+1,j) + temp + s2.substring(j+1,4);
                }
            }
        }
        return true;
    }
}