package com.leetcode.Hot206_reverseList;

public class Main {
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode reverseList = solution.reverseList(head);
        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }
    }
}
