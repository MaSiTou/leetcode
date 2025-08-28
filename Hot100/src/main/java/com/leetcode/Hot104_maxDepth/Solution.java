package com.leetcode.Hot104_maxDepth;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while(queue.size()!=0){
            int size = queue.size();
            while (size > 0){
                TreeNode temp = queue.poll();
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right !=null){
                    queue.add(temp.right);
                }
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
