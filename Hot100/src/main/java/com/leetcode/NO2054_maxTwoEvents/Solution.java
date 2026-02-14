package com.leetcode.NO2054_maxTwoEvents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Event implements Comparable<Event>{
    int time;
    int status;
    int val;
    public Event(int time,int status,int val){
        this.time = time;
        this.status = status;
        this.val = val;
    }
    @Override
    public int compareTo(Event other) {
        if (this.time != other.time) {
            return Integer.compare(this.time, other.time);
        }
        return Integer.compare(this.status, other.status);
    }
}
class Solution {
    public int maxTwoEvents(int[][] events) {
        List<Event> list = new ArrayList<>();
        for(int[] event:events){
            list.add(new Event(event[0],0,event[2]));
            list.add(new Event(event[1],1,event[2]));
        }
        Collections.sort(list);
        int firstVal = 0;
        int allVal = 0;
        for(Event e:list){
            if (e.status == 0){
                allVal = Math.max(allVal,e.val + firstVal);
            }else{
                firstVal = Math.max(firstVal,e.val);
            }
        }
        return allVal;
    }
}