package com.Hot226_invertTree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution_bset {
    public TreeNode invertTree(TreeNode root){
        if (root==null) {
            return root;
        }
        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            TreeNode popNode = deque.poll();
            TreeNode temp=  popNode.left;
            popNode.left = popNode.right;
            popNode.right  =temp;
            if (popNode.left!=null){
                deque.offer(popNode.left);
            }
            if (popNode.right!=null){
                deque.offer(popNode.right);
            }
        }
        return root;
    }
}
