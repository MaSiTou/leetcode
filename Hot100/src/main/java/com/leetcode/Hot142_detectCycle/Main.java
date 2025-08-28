package com.leetcode.Hot142_detectCycle;




public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list2;
        SolutionBest s = new SolutionBest();
        System.out.println(s.detectCycle(list1).val);
    }
}
