package com.company.codingscales.leetcode.concepts.trees;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayDeque;

public class BinaryTreeCousins {
    public boolean isCousins(final TreeNode root, final int x, final int y) {
        final ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int n;
        int count;

        while(!deque.isEmpty()) {
            n = deque.size();
            count = 0;

            for(int i = 0; i < n; i++) {
                final TreeNode node = deque.poll();

                if ((node.left != null && (node.left.val == x || node.left.val == y)) ||
                    (node.right != null && (node.right.val == x || node.right.val == y))) {
                    count ++;
                }

                if (node.left != null) { deque.offer(node.left); }
                if (node.right != null) { deque.offer(node.right); }
            }

            if (count == 2) { return true; }
            else if (count == 1) { return false; }
        }

        return false;
    }

    int seen = -1;
    boolean ans = false;


    // use this
    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        return ans;
    }

    private boolean dfs(TreeNode r, int depth, int x, int y) {
        if (r == null)
            return false;
        if (seen != -1 && depth > seen)
            return false;

        if (r.val == x || r.val == y) {
            if (seen == -1) {
                seen = depth;
                return true;
            } else {
                return seen == depth;
            }
        }

        boolean left = dfs(r.left, depth + 1, x, y);
        boolean right = dfs(r.right, depth + 1, x, y);

        if (left && right && seen != depth + 1)
            ans = true;

        return left || right;
    }

    public static void main(final String[] args) {
        final BinaryTreeCousins binaryTreeCousins = new BinaryTreeCousins();
        System.out.println(binaryTreeCousins.isCousins(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,4]"), 2, 3));
        System.out.println(binaryTreeCousins.isCousins(LeetCodeInputHelpers.stringToTreeNode(" [1,2,3,null,4,null,5]"), 5, 4));
        System.out.println(binaryTreeCousins.isCousins(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,null,4]"), 2, 3));
    }
}

