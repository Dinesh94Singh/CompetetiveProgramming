package com.company.codingscales.interviews.microsoft;

import com.company.codingscales.leetcode.concepts.trees.TreeNode;

public class CountVisibleNodesInBinaryTree {

    public int solve(final TreeNode root){
        return dfs(root,Integer.MIN_VALUE);
    }

    public int dfs(final TreeNode node, int maxValue){
        if(node==null){
            return 0;
        }

        int count=0;
        if(node.val>=maxValue){
            count = count+1;
            maxValue = node.val;
        }

        count = count + dfs(node.left,maxValue)+dfs(node.right,maxValue);

        return count;
    }
}
