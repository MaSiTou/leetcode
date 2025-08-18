package com.Hot11_maArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int maxAreat(int[] height){
        // 双指针
        // Area = min(height[left],height[right])*(right-left)
        // 如果说移动短板，那么短板可能会变大，面积可能会变大
        // 如果说移动长板，短板可能会变小，也可能会不变 ，面积一定会变小
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right){
            int area = Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(maxArea,area);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
