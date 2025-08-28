package com.leetcode.Hot1_twoSum;

import java.util.HashMap;

public class Solution_best {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.containsValue(target - nums[i]) && !map.containsKey(i)){
                return new int[]{i,map.get(i)};
            }
        }
        return null;
    }
}
