package com.company.codingscales.leetcode.concepts.trees;

import java.util.*;

public class GetLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.pollFirst();
                if (curr.left == null) {
                    if (curr.right != null) {
                        res.add(curr.right.val);
                        q.offerLast(curr.right);
                    }
                } else if (curr.right == null) {
                    res.add(curr.left.val);
                    q.offerLast(curr.left);
                } else {
                    q.offerLast(curr.left);
                    q.offerLast(curr.right);
                }
            }
        }

        return res;
    }
}
