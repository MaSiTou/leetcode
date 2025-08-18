package com.Hot279_numSquares;

public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        for (int i=1;i <= n;i++){
            int minn = Integer.MAX_VALUE;
            for (int j=1;j <= Math.sqrt(i);j++){
                minn = Math.min(minn,f[i - j * j]);
            }
            f[i] = 1 + minn;
            System.out.println("f[" + i  + "] : " + f[i]);
        }
        return f[n];
//        int[] f = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            int minn = Integer.MAX_VALUE;
//            for (int j = 1; j * j <= i; j++) {
//                minn = Math.min(minn, f[i - j * j]);
//            }
//            f[i] = minn + 1;
//            System.out.println("f[" + i  + "] : " + f[i]);
//        }
//        return f[n];


    }
}
