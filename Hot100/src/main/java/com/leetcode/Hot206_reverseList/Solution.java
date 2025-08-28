package com.leetcode.Hot206_reverseList;


public class Solution {
//    public ListNode reverseList(ListNode head)
//    {
//        //使用迭代的方式进行计算
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode temp = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = temp;
//        }
//        return newHead;
//    }
    public ListNode reverseList(ListNode head)
    {
        //使用递归的方式进行计算
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
