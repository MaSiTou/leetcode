package com.leetcode.NO3074_minimumBixes;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
//        s.minimumBoxes(new int[]{1,3,2},new int[]{4,3,1,5,2});
        int [] arr = new int[]{7,8,2,5,4,9,1,6,3};
//        s.BubbleSort(arr);
//        s.SelectionSort(arr);
        s.QuickSort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
