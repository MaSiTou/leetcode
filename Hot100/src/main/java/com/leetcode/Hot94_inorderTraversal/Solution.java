package com.leetcode.Hot94_inorderTraversal;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
