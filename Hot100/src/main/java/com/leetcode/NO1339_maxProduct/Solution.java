package com.leetcode.NO1339_maxProduct;


import java.util.ArrayList;
import java.util.List;

/**
 * 从下网上找到所有子节点最大的节点，同时，某一个节点找到之后，将他的子节点的值加入到当前节点
 */
class Solution {
    public int maxProduct(TreeNode root) {
        int MODE = 1_000_000_007;
        //List记录所有的每个节点最大的子节点
        List<Integer> maxEveryNode = new ArrayList<>();
        int sum = dfs(root,maxEveryNode);
        long maxResult = Integer.MIN_VALUE;
        System.out.println(sum);
        for(int nodeVal:maxEveryNode){
            System.out.println(nodeVal);
            long tempResult = (long) nodeVal *(sum-nodeVal);
            if (maxResult < tempResult){
                maxResult = tempResult;
            }
        }
        return (int)(maxResult%MODE);
    }
    //返回的是当前节点的val;
    public int dfs(TreeNode root, List<Integer> list){
        if (root == null){
            return 0 ;
        }
        int leftVal = dfs(root.left,list);
        int rightVal = dfs(root.right,list);
        int maxChildNodeVal = Math.max(leftVal,rightVal);
        if (maxChildNodeVal != 0){
            list.add(maxChildNodeVal);
        }
        root.val += leftVal + rightVal;
        return root.val;
    }
}