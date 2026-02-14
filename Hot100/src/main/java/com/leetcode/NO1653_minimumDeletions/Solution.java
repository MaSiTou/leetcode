package com.leetcode.NO1653_minimumDeletions;

class Solution {
    public int minimumDeletions(String s) {
        int length = s.length();
        int[] has_a_numbers = new int[length];
        int a_of_numbers = 0;
        for(int i = length-1;i>=0;i--){
            a_of_numbers += s.charAt(i)=='a'?1:0;
            has_a_numbers[i] = a_of_numbers;
        }
        int begin = 0;
        while(begin < length && s.charAt(begin)=='b'){
            begin++;
        }
        while(begin < length){
           while(begin <length && s.charAt(begin)=='a'){
               begin++;
           }

        }
        return 0;
    }
}