package com.Hot49_groupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //将strs的每个字符串排序之后保存到map中，key为返回的最外层的列表的索引，value为排序后的字符串
        Map<String, List<String>> map = new HashMap<>();
        List<List<String> > list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s,temp);
            }
        }
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            list.add(entry.getValue());

        }

        return list;


    }
}
