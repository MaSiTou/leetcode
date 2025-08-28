package com.leetcode.Hot49_groupAnagrams;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}
