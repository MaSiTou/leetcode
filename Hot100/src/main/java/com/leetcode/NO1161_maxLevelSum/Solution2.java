package com.leetcode.NO1161_maxLevelSum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int maxLevelSum(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root,1,list);
        int maxLevelIndex = 0;
        for(int i=0;i<list.size();i++){
            if (list.get(maxLevelIndex) < list.get(i)){
                maxLevelIndex = i;
            }
        }
        return maxLevelIndex+1;
    }
    public void dfs(TreeNode root, int level, List<Integer> list){
        if (root==null){
            return;
        }
        if (list.size()+1 == level){
            list.add(root.val);
        }else{
            list.set(level-1,list.get(level-1)+root.val);
        }
        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);
    }
}
