package com.leetcode.Hot102_LevelTraversal;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        node1.right = node2;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);
        for (List<Integer> l : result){
            for (Integer x : l){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
