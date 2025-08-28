package com.leetcode.Hot234_isPalindrome;

import java.util.*;

public class Solution {
    public static boolean isPalindrom(ListNode head){
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i=0,j=list.size()-1;i<=j;i++,j--){
           if (list.get(i)!=list.get(j)){
               return false;
           }else if (i==j){
               return true;
           }else {
               continue;
           }

        }
        return true;
    }
}
