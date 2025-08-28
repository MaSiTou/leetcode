package com.leetcode.Hot141_hasCycle;


public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(1);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list2;
        Solution s = new Solution();
        System.out.println(s.hasCycle(list1));
    }
}
