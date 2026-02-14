package com.leetcode.NO3433_countMentions;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
//        boolean[] status = new boolean[numberOfUsers];
//        Arrays.fill(status,true);
        int[] offlineTime = new int[numberOfUsers];
        Arrays.fill(offlineTime,-1);
        int[] ans = new int[numberOfUsers];
        Collections.sort(events, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int timeCompare =  Integer.parseInt(o1.get(1))-Integer.parseInt(o2.get(1)) ;
                if(timeCompare!=0){
                    return timeCompare;
                }
                return -o1.get(0).compareTo(o2.get(0));
            }
        });
        for(List<String> listtemp:events){
            for(String stemp:listtemp){
                System.out.print(stemp + " ");
            }
            System.out.println();
        }
        for(List<String> list:events){
            String event = list.get(0);
            int timeStamp = Integer.parseInt(list.get(1));
            String ids = list.get(2);
            if(event.equals("MESSAGE")){
                if(ids.equals("ALL")){
                    //stream流 ans 全部加1
                    //只是操作副本
//                    Arrays.stream(ans).forEach(x->x++);
                    IntStream.range(0, ans.length).forEach(i -> ans[i]++);
                    System.out.println("0-2 " + ans[0]);
                }else if(ids.equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(isaBoolean(i, offlineTime, timeStamp)){
                            ans[i]++;
                        }
                    }
                }else{
                    //获取所有的id
                    int[] idNumber = Arrays.stream(ids.split(" "))
                            .map(s->s.substring(2))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    //
                    for(int i =0;i<idNumber.length;i++){
//                        if(isaBoolean(idNumber[0], offlineTime, timeStamp)){
                            ans[idNumber[i]]++;
//                        }
                    }
                    System.out.println("0-1" + ans[0]);
                }
            }else{
                int nowId = Integer.parseInt(ids);
                offlineTime[nowId] = timeStamp;
                System.out.println(nowId + " " + offlineTime[nowId]);
            }
        }
        return ans;
    }

    private static boolean isaBoolean(int i, int[] offlineTime, int timeStamp) {
//        if(offlineTime[i] !=-1 && (offlineTime[i] + 60) > timeStamp)
        return offlineTime[i] == -1 || ((offlineTime[i] + 60) <= timeStamp);
    }
}