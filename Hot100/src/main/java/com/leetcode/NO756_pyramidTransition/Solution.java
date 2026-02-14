package com.leetcode.NO756_pyramidTransition;

import java.util.*;

/**
 * 总体是一个DFS的思想，当前位置是[i,j]，根据[i+1,j]和[i+1.j+1]查询allowed是否有合适的，然后进行[i,j+1]的一直到i=0，返回true;
 */
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> map = new HashMap<>();
        //记录s.substring(0,2)作为bottom时候 顶部可以的选择
        for(String s:allowed){
            if (map.containsKey(s.substring(0,2))){
                map.get(s.substring(0,2)).add(s.charAt(2));
            }else{
                map.put(s.substring(0,2),new ArrayList<>(){{add(s.charAt(2));}});
            }
        }
        char[][] pyramid = new char[bottom.length()][];
        for(int i=0;i<bottom.length()-1;i++){
            pyramid[i] = new char[i+1];
        }
        pyramid[bottom.length()-1] = bottom.toCharArray();
        return dfs(bottom.length()-2,0,pyramid,map);
    }
    public boolean dfs(int i,int j,char[][] pyramid,Map<String,List<Character>> map){

        if (i < 0){
            return true;
        }
        if (j >= i+1){
            return dfs(i-1,0,pyramid,map);
        }
        StringBuilder nowBottom = new StringBuilder();
        nowBottom.append(pyramid[i+1][j]);
        nowBottom.append(pyramid[i+1][j+1]);
        if(!map.containsKey(nowBottom.toString())){
            return false;
        }
        for(char c:map.get(nowBottom.toString())){
            pyramid[i][j] = c;
            if (dfs(i,j+1,pyramid,map)){
                return true;
            }
        }
        return false;
    }
}