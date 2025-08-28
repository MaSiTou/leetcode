package com.leetcode.Hot2_addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int flag = 0;
        while(l1!=null || l2 != null){
            temp.next = new ListNode();
            temp = temp.next;
            temp.val = l1==null? l2.val+flag:l2==null?l1.val+flag:l1.val+l2.val+flag;
            if (temp.val >=10){
                temp.val = temp.val %10;
                flag = 1;
            }else{
                flag = 0;
            }
            System.out.println(temp.val);

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if (flag == 0){
            return result.next;
        }
        else{
            temp.next = new ListNode(1);
            return result.next;
        }
    }
}
