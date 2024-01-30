package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

/**
 * DeleteNodesAndReturnForest
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] A) {
        HashSet<Integer> toDelete = new HashSet<>();

        for(int a : A) {
            toDelete.add(a);
        }

        dfs(root, null, toDelete);
        if (!toDelete.contains(root.val)) {
            res.add(root);
        }

        return res;
    }

    private void dfs(TreeNode root, TreeNode parent, HashSet<Integer> toDelete) {
        if (root == null)
            return;

        if (toDelete.contains(root.val)) {
            if (parent != null) {
                if (parent.left != null && parent.left.val == root.val) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            if (root.left != null && !toDelete.contains(root.left.val)) {
                res.add(root.left);
            }

            if (root.right != null && !toDelete.contains(root.right.val)) {
                res.add(root.right);
            }
        }


        dfs(root.left, root, toDelete);
        dfs(root.right, root, toDelete);
    }
}
