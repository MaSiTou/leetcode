package com.leetcode.NO2975_maximizeSquareArea;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 9;
        int n = 7;
        int[] hFences = new int[]{6,4,7,5,8};
        int[] vFences = new int[]{6,4,2,3};
        System.out.println(s.maximizeSquareArea(m,n,hFences,vFences));;
    }
}
