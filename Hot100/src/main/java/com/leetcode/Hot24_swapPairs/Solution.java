package com.leetcode.Hot24_swapPairs;


public class Solution {
    public static void main(String[] args) {
         ListNode root = new ListNode(2);
         root.next = new ListNode(5);
         root.next.next = new ListNode(3);
         root.next.next.next = new ListNode(4);
         root.next.next.next.next = new ListNode(6);
         root.next.next.next.next.next = new ListNode(2);
        ListNode swappedPairs = swapPairs(root);
        while(swappedPairs!=null){
            System.out.println(swappedPairs.val);
            swappedPairs = swappedPairs.next;
         }
    }
    public static ListNode swapPairs(ListNode head){
        if (head == null) return null;
        ListNode result = new ListNode(0,head);
        ListNode r = result;
        ListNode left = head,right=head.next;
        while(right !=null){
            ListNode temp = right.next;
            result.next = right;
            right.next = left;
            left.next = temp;
            result = left;
            left = temp;
            if (temp == null) break;
            right = temp.next;
        }
        return r.next;
    }
}
