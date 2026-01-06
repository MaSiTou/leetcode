package com.leetcode.NO1200_minimumAbsDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int tempDifference = arr[i+1] - arr[i];
            int finalI = i;
            if (tempDifference < minDifference){
                minDifference = tempDifference;
                list.clear();
                list.add(new ArrayList<>(){{
                    add(arr[finalI]);
                    add(arr[finalI +1]);
                }});
            }else if (tempDifference == minDifference){
                list.add(new ArrayList<>(){{
                    add(arr[finalI]);
                    add(arr[finalI +1]);
                }});
            }else{
                continue;
            }
        }
        return list;
    }
}