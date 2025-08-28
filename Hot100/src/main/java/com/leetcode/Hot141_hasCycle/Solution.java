package com.leetcode.Hot141_hasCycle;


public class Solution {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next ==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while(low!=fast){
            if (low == null || fast == null || fast.next==null){
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }
}
