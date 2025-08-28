package com.leetcode.Hot94_inorderTraversal;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        SolutionBest solution = new SolutionBest();
        List<Integer> list = solution.inorderTraversal(root);
        for(int i:list){
            System.out.println(i);
        }

    }
}
