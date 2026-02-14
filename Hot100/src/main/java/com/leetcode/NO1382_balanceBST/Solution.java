package com.leetcode.NO1382_balanceBST;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        for(Integer i:list){
            System.out.println(i);
        }
        return buildBST(list,0,list.size());
    }

    public void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }

    public TreeNode buildBST(List<Integer> list,int begin,int end){
        if (begin >= end){
            return null;
        }
        int n = (begin + end) >>> 1 ;
        TreeNode root = new TreeNode(list.get(n));
        root.left = buildBST(list,begin,n);
        root.right = buildBST(list,n+1,end);
        return root;
    }
}