package com.leetcode.Hot543_diameterOfBinaryTree;

public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root){

        //使用map<TreeNode,int[2]>存储当前点的左右两个点的深度信息
        int maxdepth = dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
