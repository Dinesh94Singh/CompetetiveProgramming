package com.company.codingscales.leetcode.concepts.trees;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class DirectlyRelatedBinaryTree {
    private static boolean recHelper(final TreeNode root, final int x, final int y) {
        if (root == null) {
            return false;
        }

        final boolean foundLeft = recHelper(root.left, x, y);
        final boolean foundRight = recHelper(root.right, x, y);

        boolean found = false;

        if (root.val == x || root.val == y) {
            found = true;
        }


        if (foundLeft && foundRight) {
            if ((root.left.val == x || root.left.val == y) && (root.right.val == x || root.right.val == y)) {
                return false;
            }
        } else if (found && (foundLeft || foundRight)) {
            return !((root.left != null && (root.left.val == x || root.left.val == y)) || (root.right != null && (root.right.val == x || root.right.val == y)));
        }

        return found || foundLeft || foundRight;
    }

    public static boolean directlyRelated(final TreeNode root, final int x, final int y) {
        if (root == null) { return false; }
        return recHelper(root, x, y);
    }

    public static void main(final String[] args) {
        System.out.println(directlyRelated(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,4]"), 3, 4));
        System.out.println(directlyRelated(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,4]"), 2, 3));
        System.out.println(directlyRelated(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,4]"), 2, 4));
    }
}
