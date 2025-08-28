package com.leetcode.Hot226_invertTree;

public class Solution {

    public void invert(TreeNode t){
        if (t.left !=null && t.right !=null){
            TreeNode temp = t.left;
            t.left  = t.right;
            t.right = temp;
        }
        if (t.left!=null){
            invert(t.left);
        }
        if (t.right!=null){
            invert(t.right);
        }
    }
    public TreeNode invertTree(TreeNode root){
        if (root!=null) {
            invert(root);
        }

        return root;
    }
}
