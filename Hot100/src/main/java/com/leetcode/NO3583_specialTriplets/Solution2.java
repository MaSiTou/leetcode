package com.leetcode.NO3583_specialTriplets;

import java.util.HashMap;
import java.util.Map;

/**
 * 三个指针，基本思想遍历中间元素
 */
public class Solution2 {
    public int specialTriplets(int[] nums){
        long mod = 1_000_000_007;
        Map<Integer,Integer> all = new HashMap<>();//其实是作为右边的元素的个数
        for(int i=0;i<nums.length;i++){
            all.merge(nums[i],1,Integer::sum);
        }
        long ans = 0;
        Map<Integer,Integer> left = new HashMap<>();
        for(Integer x:nums){
            //首先应该更新右边的元素
            all.merge(x,-1,Integer::sum);
            //总的计算方式是左边的(2*x) * (2*x)
            //计算左边的2*x的数量
            int leftNumber = left.getOrDefault(2*x,0);

            //计算右边的2*x的数量
            int rightNuber = all.getOrDefault(2*x,0);
            System.out.println(leftNumber + " "  + rightNuber);
            ans = (ans + (long)leftNumber * rightNuber);
            //更新左边的元素
            left.merge(x ,1,Integer::sum);
        }
        return (int)(ans % (mod));
    }
}
