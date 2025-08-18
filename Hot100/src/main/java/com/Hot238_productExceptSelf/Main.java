package com.Hot238_productExceptSelf;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};

        Solution s = new Solution();

        int[] result = s.productExceptSelf(nums);

        for (int r:result){
            System.out.println(r);
        }
    }
}
