package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);

        boolean isLeft = true;
        while(!dq.isEmpty()) {
            int n = dq.size();
            LinkedList<Integer> t = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode curr = dq.pollFirst();

                if (isLeft) {
                    t.offerLast(curr.val);
                } else {
                    t.offerFirst(curr.val);
                }

                if (curr.left != null)
                    dq.offerLast(curr.left);
                if (curr.right != null)
                    dq.offerLast(curr.right);
            }

            res.add(t);
            isLeft = !isLeft;
        }

        return res;
    }
}
