package com.leetcode.Hot15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //采用先排序，再根据和为0使用双指针进行计算
        //重点在去去除重复元素,第一次循环需要去重。第二次循环每次l++之后，判断是否和上次一样，如果一样，则跳过。
        //然后r不用判断了。
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                    while ( left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }


            }
        }
        return lists;
    }
}
