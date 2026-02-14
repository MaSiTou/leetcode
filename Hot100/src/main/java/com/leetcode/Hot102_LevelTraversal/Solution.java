package com.leetcode.Hot102_LevelTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while(size>0){
                TreeNode temp = queue.poll();
                if (temp!=null){
                    levelList.add(temp.val);
                    queue.add(temp.left);
                    queue.offer(temp.right);
                }
                size--;
            }
            if (!levelList.isEmpty()){
                result.add(levelList);
            }
        }
        return result;
    }
}
