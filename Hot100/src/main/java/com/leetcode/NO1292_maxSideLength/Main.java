package com.leetcode.NO1292_maxSideLength;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] array= new int[][]{
//                {1,1,3,2,4,3,2},
//                {1,1,3,2,4,3,2},
//                {1,1,3,2,4,3,2}
//        };
//        int[][] array =new int[][]{
//                {18,70},
//                {61,1},
//                {25,85},
//                {14,40},
//                {11,96},
//                {97,96},
//                {63,45}
//        };
        int[][] array = new int[][]{
                {3,6,2,5},
                {2,1,2,6},
                {2,1,3,2},
                {2,5,5,9},
                {5,5,4,2},
                {7,3,9,2}
        };
        System.out.println(s.maxSideLength(array,25));;
    }
}
