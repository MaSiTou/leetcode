package com.other.sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {
                13,2,5,1,6,3,7,5,8,2,9,4
//            3,2,1,4
        };
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
