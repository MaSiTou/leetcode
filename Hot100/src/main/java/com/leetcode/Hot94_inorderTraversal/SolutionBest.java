package com.leetcode.Hot94_inorderTraversal;



import java.util.*;

public class SolutionBest {
//    public List<Integer> inorderTraversal(TreeNode root){
//        List<Integer> result = new ArrayList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        while(root !=null || !stack.isEmpty()){
//            while(root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            result.add(root.val);
//            root = root.right;
//        }
//        return result;
//    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            root = temp.right;
        }
        return result;
    }

}
