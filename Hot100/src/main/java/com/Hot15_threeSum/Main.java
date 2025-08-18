package com.Hot15_threeSum;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }
}
