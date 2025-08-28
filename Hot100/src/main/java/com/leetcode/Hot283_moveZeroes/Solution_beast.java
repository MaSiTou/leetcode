package com.leetcode.Hot283_moveZeroes;

public class Solution_beast {
    public void moveZeroes(int[] nums)
    {
        //可以想象先新建一个数组，每个不为0data的都往前面放，然后把后面的都置为0，
        //所以只需要遍历数组，找到不为0的元素即可
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}
