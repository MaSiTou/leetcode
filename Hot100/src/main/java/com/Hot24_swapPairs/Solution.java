package com.Hot24_swapPairs;


public class Solution {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head){
        if (head==null){
            return null;
        }
        else if (head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while(right !=null){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            left = right.next;
            if (left==null){
                return head;
            }
            right = left.next;
        }
        return head;
    }
}
