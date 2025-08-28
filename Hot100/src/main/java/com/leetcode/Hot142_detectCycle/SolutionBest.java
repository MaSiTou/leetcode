package com.leetcode.Hot142_detectCycle;

public class SolutionBest {
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast && fast!=null){
            slow = slow.next;
            if (fast.next == null){
                return  null;
            }
            fast = fast.next.next;
        }
        return slow;
    }
}
