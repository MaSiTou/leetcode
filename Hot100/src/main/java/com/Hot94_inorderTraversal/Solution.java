package com.Hot94_inorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        //使用递归的方式，比较简单
        if (root == null)
        {
            return null;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
//    public List<Integer> inorderTraversal(TreeNode root)
//    {
//        //使用迭代的方式，利用栈先进后出的原理
//        if (root==null){
//            return ;
//        }
//        Stack<TreeNode> s = new Stack<>();
//
//    }
}
