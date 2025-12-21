package com.leetcode.NO944_minDeletionSize;


/**
 * 行列不分！
 * 行列不分！
 * 行列不分!
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        boolean[] ans = new boolean[strs[0].length()];
        String lastString = strs[0];
        for(int i=1;i<strs.length;i++){
            for(int j=0;j<strs[0].length();j++){
                if (strs[i].charAt(j) < lastString.charAt(j) && !ans[j]){
                    ans[j] = true;
                }
            }
            lastString = strs[i];
        }
        int result = 0;
        for(boolean bl:ans){
            if (bl){
                result++;
            }
        }
        return result;
    }
}