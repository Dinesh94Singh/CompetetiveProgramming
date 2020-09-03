package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class KthSmallestInBST {
    public int kthSmallest(final TreeNode root, final int k) {
        int count = k;

        final ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            if (stack.isEmpty()) {
                return -1;
            }
            curr = stack.removeLast();
            count -= 1;
            if (count == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    public static void main(final String[] args) {
        final KthSmallestInBST kthSmallestInBST = new KthSmallestInBST();
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallestInBST.kthSmallest(root, 1));
    }
}
