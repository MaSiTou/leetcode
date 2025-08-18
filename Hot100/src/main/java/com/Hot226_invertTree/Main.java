package com.Hot226_invertTree;

public class Main {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left  = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t2.left = t4;
        t4.right = t5;
        Solution s = new Solution();
        TreeNode root = s.invertTree(t1);
    }
}
