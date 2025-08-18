package com.Hot25_reverseKGroup;

import java.util.Stack;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> s = new Stack<>();
        ListNode Head = null;
        int count = 0;
        while(head!=null){
            if (count==0 || count % k !=0 ){
                s.push(head);
                head = head.next;
                count++;
            }else {
                while (!s.isEmpty()) {
                    Head.next = s.pop();
                    Head = Head.next;
                }
                count = 0;
            }
        }
        if (count%k != 0){
            ListNode temp = null;
            while (!s.isEmpty()) {
                ListNode cur = s.pop();
                cur.next = temp;
                temp = cur;
            }
            Head.next = temp;
        }
        else{
            while (!s.isEmpty()) {
               Head.next = s.pop();
               Head = Head.next;
            }
        }
        return Head;
    }
}
