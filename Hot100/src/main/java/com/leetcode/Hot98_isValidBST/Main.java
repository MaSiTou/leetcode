package com.leetcode.Hot98_isValidBST;


public class Main {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        t1.left = t2;
        t1.right  = t3;
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(8);
        t2.left = t4;
        t2.right = t5;
        Solution  s = new Solution();
        System.out.println(s.isValidBST(t1));
    }
}
