package com.leetcode.NO3433_countMentions;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> list = Arrays.asList(
    Arrays.asList("MESSAGE", "1", "id0 id1"),
    Arrays.asList("MESSAGE", "5", "id2"),
    Arrays.asList("MESSAGE", "6", "ALL"),
    Arrays.asList("OFFLINE", "5", "2")
);


        for(int i:solution.countMentions(3,list)){
            System.out.println(i);
        }
    }
}
