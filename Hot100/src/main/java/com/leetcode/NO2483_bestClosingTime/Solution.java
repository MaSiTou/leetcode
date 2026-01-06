package com.leetcode.NO2483_bestClosingTime;

class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] leftNNumber = new int[n+1];
        int[] rightYNumber = new int[n+1];
        int left = 0;
        for(int i=0;i<=n;i++){
            leftNNumber[i] = left;
            if (i < n && customers.charAt(i) == 'N'){
                left++;
            }
        }
        int right = 0;
        for(int i = n-1;i>=0;i--){
            if (customers.charAt(i) =='Y'){
                right++;
            }
            rightYNumber[i] = right;
        }
        int minPriority = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<=n;i++){
            System.out.println(leftNNumber[i] + " " + rightYNumber[i]);
            if (minPriority > leftNNumber[i] + rightYNumber[i]){
                minPriority = leftNNumber[i] + rightYNumber[i];
                index = i;
            }
        }
        return index;
    }
}