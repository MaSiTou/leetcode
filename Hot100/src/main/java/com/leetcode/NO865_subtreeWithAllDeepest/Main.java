package com.leetcode.NO865_subtreeWithAllDeepest;

public class Main {
    public static void main(String[] args) {
//        TreeNode l2 = new TreeNode(4);
//        TreeNode r2 = new TreeNode(2);
//        TreeNode l1 = new TreeNode(1,l2,r2);
//        TreeNode r1 = new TreeNode(3);
//        TreeNode root = new TreeNode(0,l1,r1);
        TreeNode l31 = new TreeNode(6);
        TreeNode l32 = new TreeNode(5);
        TreeNode r3 = new TreeNode(4);
        TreeNode l2 = new TreeNode(3,l31,null);
        TreeNode r2 = new TreeNode(2,l32,r3);
        TreeNode l1 = new TreeNode(1,l2,r2);
        TreeNode root = new TreeNode(0,l1,null);
        Solution solution = new Solution();
        System.out.println(solution.subtreeWithAllDeepest(root).val);;
    }
}
