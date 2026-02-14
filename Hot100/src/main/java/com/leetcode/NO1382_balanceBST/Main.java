package com.leetcode.NO1382_balanceBST;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //帮我构造一个不平衡的二叉搜索树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
//        root.right.right.right.right = new TreeNode(5);

        Solution solution = new Solution();
        TreeNode balanced = solution.balanceBST(root);
        bfs(balanced);
    }
    public static void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }

        }
    }
}
