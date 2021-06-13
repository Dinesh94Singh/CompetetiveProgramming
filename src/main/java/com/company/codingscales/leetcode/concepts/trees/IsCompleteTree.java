package com.company.codingscales.leetcode.concepts.trees;

import java.util.LinkedList;

public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        // level order traversal, push nulls also and if you encounter null previously, return false

        if (root==null)
            return true;
        // array deque doesn't accept nulls
        LinkedList<TreeNode> dq = new LinkedList<>();
        // basically Queue<TreeNode> interface

        dq.addLast(root);
        // dq.offerLast(root);

        boolean seenNull = false;

        while(!dq.isEmpty()) {

            int n = dq.size();
            while (n-- > 0) {
                TreeNode t = dq.removeFirst();

                if (t == null) {
                    seenNull = true;
                    continue;
                }
                else if (seenNull)
                    return false;

                dq.addLast(t.left);
                dq.addLast(t.right);
            }
        }

        return true;
    }
}
