package com.leetcode.NO1161_maxLevelSum;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxIndex = 1;
        int layer = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int nowSum = 0;
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                nowSum += currentNode.val;
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            if (nowSum > maxSum){
                maxSum = nowSum;
                maxIndex = layer;
            }
            layer++;
        }
        return maxIndex;
    }
}