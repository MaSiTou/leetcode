package com.leetcode.NO756_pyramidTransition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
class Solution {

    Map<String,List<String>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (map.isEmpty()){
            Init(allowed);
        }
        int beginIndex = 0;
        while(beginIndex+2 < bottom.length()){
            String bottomTemp = bottom.substring(beginIndex,beginIndex+2);
            if (!map.containsKey(bottomTemp)){
                return false;
            }else{

            }
            beginIndex++;
        }
        return true;
    }

    public void Init(List<String> allowed){
        for(String s:allowed){
            map.computeIfAbsent(s.substring(0,2),k -> new ArrayList<>()).add(String.valueOf(s.charAt(2)));
        }
    }
}