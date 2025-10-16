package com.leetcode.Hot76_MinCoverageString;

public class Solution {
    public String minWindow(String s, String t) {
      int[] cnt = new int[128];
      for(int i=0;i<t.length(); i++){
          cnt[t.charAt(i)]++;
      }
      int[] cns = new int[128];
      int left = 0;
      int minLength = s.length();
      int minL = -1;
      for(int right = 0; right < s.length();right++){
          cns[s.charAt(right)]++;
          while(fugai(cns,cnt)){
                if (minLength > right - left){
                    minLength = right - left + 1;
                    minL = left;
                }
                cns[s.charAt(left)]--;
                left++;
          }
      }
      return minL < 0 ? "":s.substring(minL,minL+minLength);
    }

    public static boolean fugai(int[] cns,int[] cnt){
        for(int i=0;i<128;i++){
            if (cns[i] < cnt[i]) return false;
        }
        return true;
    }
}
