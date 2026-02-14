package com.leetcode.Hot101_SymmetricTree;

import java.util.*;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            LinkedList<TreeNode> l = new LinkedList<>();
            while(size>0){
                TreeNode temp = deque.pop();
                l.add(temp);
                if (temp != null){
                    deque.add(temp.left);
                    deque.add(temp.right);
                }
                size--;
            }
            if (l.size() == 1){
                continue;
            }
            while(!l.isEmpty() &&
                    ((l.getFirst() == null && l.getLast() == null) || (l.getFirst()!=null && l.getLast()!=null && l.getFirst().val == l.getLast().val))
                    ){
                l.pollFirst();
                l.pollLast();
            }
            if (!l.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
