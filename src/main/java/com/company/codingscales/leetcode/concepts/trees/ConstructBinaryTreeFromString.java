package com.company.codingscales.leetcode.concepts.trees;

public class ConstructBinaryTreeFromString {
    char[] A;
    static int idx;

    public TreeNode str2tree(String s) {
        idx = 0;
        A = s.toCharArray();
        return dfs();
    }

    TreeNode dfs() {
        if (idx >= A.length)
            return null;

        int n = 0;

        boolean isNegative = false;
        if (A[idx] == '-') {
            isNegative = true;
            idx++;
        }


        while (idx < A.length && Character.isDigit(A[idx])) {
            n = n * 10 + Character.getNumericValue(A[idx]);
            idx++;
        }

        TreeNode root = new TreeNode(isNegative ? -n : n);

        if (idx < A.length && A[idx] == '(') {
            idx++;
            root.left = dfs();
        }

        if (idx < A.length && root.left != null && A[idx] == '(') {
            idx++;
            root.right = dfs();
        }

        idx++; // since one index for ')'
        return root;
    }
}
