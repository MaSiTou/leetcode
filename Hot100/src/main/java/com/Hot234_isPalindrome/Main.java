package com.Hot234_isPalindrome;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(1);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        System.out.println(Solution.isPalindrom(list1));
    }
}
