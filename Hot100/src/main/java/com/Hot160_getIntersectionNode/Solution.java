package com.Hot160_getIntersectionNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            System.out.println("headA: "+headA.val);
            ListNode temp= headB;
            while (temp != null) {
                System.out.println("headB: "+temp.val);
                if (headA == temp){
                    return headA;
                }
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
