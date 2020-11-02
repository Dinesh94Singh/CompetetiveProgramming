package com.company.codingscales.binarysearchio.concepts.trees;

public class OnlyChild {
    int count = 0;
    private void dfs(Tree root, Tree parent) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            // do nothing
        } else if (root.left == null || root.right == null) {
            count++;
        }

        dfs(root.left, root);
        dfs(root.right, root);
    }

    public int solve(Tree root) {
        if (root == null)
            return 0;


        dfs(root, null);
        return count;
    }
}
