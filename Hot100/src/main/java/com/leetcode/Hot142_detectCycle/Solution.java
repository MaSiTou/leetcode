package com.leetcode.Hot142_detectCycle;



import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
