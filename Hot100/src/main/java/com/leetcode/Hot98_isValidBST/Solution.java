package com.leetcode.Hot98_isValidBST;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValidBST(TreeNode root){
        Long last =  Long.MIN_VALUE;
      Deque<TreeNode> stack = new LinkedList<>();
      while(root !=null || !stack.isEmpty())
      {
          while(root!=null){
              stack.push(root);
              root = root.left;
          }
          root = stack.pop();
          if (last > root.val){
              return false;
          }
          last = (long) root.val;
          root = root.right;
      }
      return true;
    }
}
