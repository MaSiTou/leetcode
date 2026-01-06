package com.leetcode.NO865_subtreeWithAllDeepest;

import java.util.*;

/**
 * 先找到最大深度的所有的子节点
 * 然后找他们的公共祖先
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        int[] level = new int[]{0,0};
        List<TreeNode> list = new ArrayList<>();
        dfs(root,level,parent,list);

        Set<TreeNode> set = new HashSet<>();

        int lastIndex = Integer.MIN_VALUE;
        TreeNode result = root;
        if (list.size() == 1) return list.get(0);
        for(TreeNode node:list){
            System.out.println(node.val);
            TreeNode nowParent = node;
            int index = 0;
            while(nowParent!=null){
                index++;
                if (set.contains(nowParent)){
                    result =  lastIndex < index ? nowParent : result;
                    lastIndex = Math.max(lastIndex,index);
                    System.out.println(lastIndex + " " + index + " " + result.val);
                    break;
                }
                set.add(nowParent);
                nowParent = parent.get(nowParent);
            }
        }
        for(Map.Entry<TreeNode,TreeNode> entry:parent.entrySet()){
            System.out.println(entry.getKey().val + " -> " + entry.getValue().val);
        }
        return result;
    }
    public void dfs(TreeNode root, int[] level, Map<TreeNode,TreeNode> parent, List<TreeNode> list){
        if (root != null){
            if (level[0] == level[1]){
                list.add(root);
            }
            if (level[0] > level[1]){
                list.clear();
                list.add(root);
                level[1] = level[0];
            }
            level[0]++;
        }
        if (root.left != null){
            parent.put(root.left,root);
            dfs(root.left,level,parent,list);
        }
        if (root.right != null){
            parent.put(root.right,root);
            dfs(root.right,level,parent,list);
        }
        level[0]--;
    }
}