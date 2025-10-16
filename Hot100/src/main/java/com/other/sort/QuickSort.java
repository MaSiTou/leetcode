package com.other.sort;


public class QuickSort {
    public void quickSort(int[] arr,int i,int j){
        if(arr == null || i>=j){
            return;
        }
        int partition = partition(arr, i, j);
        quickSort(arr,i,partition-1);
        quickSort(arr,partition+1,j);
    }
//    public int partition(int[] arr,int begin,int end){
//        int flag = arr[begin];
//        int i=begin+1;
//        int j=end;
//        while(i<=j){
//            while(i<=j && arr[i] < flag){
//                i++;
//            }
//            while(i<=j && arr[j] > flag){
//                j--;
//            }
//            if(i<=j){
//                swap(arr,i,j);
//                i++;
//                j--;
//            }
//        }
//        swap(arr,begin,j);
//        return j;
//    }
    public int partition(int [] arr,int low,int high){
        int flag = arr[low];
        int i = low;
        int j = low+1;
        while(j<=high){
            if (arr[j] < flag){
                i++;
                swap(arr,i,j);
            }
            j++;
        }
        swap(arr,low,i);
        return i;
    }
    public void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
