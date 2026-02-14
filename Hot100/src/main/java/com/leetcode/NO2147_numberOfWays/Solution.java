package com.leetcode.NO2147_numberOfWays;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfWays(String corridor) {
        int ans = 1;
        char[] chars = corridor.toCharArray();
        List<String> list = new ArrayList<>();
        int s_number = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){
            sb.append(chars[i]);
            if(chars[i] == 'S'){
                s_number++;
            }
            if (s_number == 0){
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            if (s_number==2){
                s_number = 0;
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(s_number!=0) return 0;
        List<Integer> indexs = new ArrayList<>();
        String[] arrayList = list.toArray(new String[0]);
        for(int i=0;i<arrayList.length;i++){
            System.out.println(arrayList[i]);
            if (arrayList[i].length()>=2){
                indexs.add(i);
            }
        }
        for(int i=1;i<indexs.size();i++){
            int interval = indexs.get(i) - indexs.get(i-1);
            System.out.println(interval);
            ans = (int)((long)ans * interval % 1_000_000_007);
        }
        return indexs.isEmpty() ? 0:ans;
    }
}