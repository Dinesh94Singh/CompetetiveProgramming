package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        rec_helper(root, new ArrayList<Integer>(), sum);
        return res;
    }

    public void rec_helper(TreeNode root, List<Integer> temp, int sum) {
        if(root == null) {
            return ;
        }

        temp.add(root.val);

        if  (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList(temp));
        }

        rec_helper(root.right, temp,sum-(root.val));
        rec_helper(root.left, temp, sum-(root.val));

        temp.remove(temp.size() - 1);
    }
}
