package com.company.codingscales.leetcode.concepts.trees;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class ValidateTreeSequence {
    private static boolean recHelper(final TreeNode root, final int index, final int[] arr) {
        if (arr.length == index && root == null) return true;
        else if (arr.length == index || root == null) return false;

        if (arr[index] != root.val) return false;

        final boolean left = recHelper(root.left, index + 1, arr);
        final boolean right = recHelper(root.right, index + 1, arr);

        return left || right;
    }

    public static boolean isValidSequence(final TreeNode root, final int[] arr) {
        return recHelper(root, 0, arr);
    }

    public static void main(final String[] args) {
        System.out.println(isValidSequence(LeetCodeInputHelpers.stringToTreeNode("[8,3,null,2,1,5,4]"), LeetCodeInputHelpers.stringToIntArray("[8]")));
    }
}
