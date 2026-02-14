package com.leetcode.NO2976_minimumCost;

public class  Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost("abcd","abce",new char[]{'a'},new char[]{'e'},new int[]{10000}));;
    }
}
//{'a','b','c','c','e','d'}  {'b','c','b','e','b','e'} {2,5,5,1,2,20}