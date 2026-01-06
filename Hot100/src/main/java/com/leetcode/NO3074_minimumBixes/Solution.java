package com.leetcode.NO3074_minimumBixes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int e:apple){
            sum+=e;
        }
        // 将int类型数组转为Integer类型的数组
//        Integer[] capacityInteger = Arrays.stream( capacity).boxed().toArray(Integer[]::new);
//        Arrays.sort(capacityInteger,(a,b) -> b - a );
//        for(int i=0;i<capacityInteger.length;i++){
//            sum -= capacityInteger[i];
//            if (sum <=0){
//                return i+1;
//            }
//        }
        // 将数组转为list在排序
        List<Integer> capacityList = Arrays.stream(capacity).boxed().collect(Collectors.toList());
        Collections.sort(capacityList, (a,b) -> b - a);
        for(int i=0;i<capacityList.size();i++){
            sum -= capacityList.get(i);
            if (sum <=0){
                return i+1;
            }
        }
        return capacityList.size();
    }
    //冒泡排序
    public void BubbleSort(int[] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length-1-i;j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //选择排序
    public void SelectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int maxIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[j] < arr[maxIndex]){
                    maxIndex = j;
                }
            }
            if (maxIndex != i){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    //快速排序
    public void QuickSort(int[] arr,int low ,int high){
        if (low < high){
            int index = partition(arr,low,high);
            QuickSort(arr,low,index-1);
            QuickSort(arr,index+1,high);
        }
    }
    public int partition(int[] arr,int low,int high){
        //以右元素为边界
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}