package com.leetcode.Hot76_MinCoverageString;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "BBBBABDAABC";
        String t = "ABC";
        System.out.println(solution.minWindow(s,t));
    }
}
