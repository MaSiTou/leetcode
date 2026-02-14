package com.leetcode.Hot110_isBalanced;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeigth(root) != -1;
    }
    public int getHeigth(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHeight  = getHeigth(node.left);
        int rightHeight = getHeigth(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}