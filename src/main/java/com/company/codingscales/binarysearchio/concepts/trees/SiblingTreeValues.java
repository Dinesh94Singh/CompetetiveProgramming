package com.company.codingscales.binarysearchio.concepts.trees;

public class SiblingTreeValues {
    int ans = -1;
    private void dfs(Tree root, Tree parent, int k) {
        if (root == null) {
            return;
        }

        if (root.val == k) {
            if (parent != null && parent.left == root) {
                ans = parent.right.val;
            } else if (parent != null && parent.right == root) {
                ans = parent.left.val;
            }
        }

        dfs(root.left, root, k);
        dfs(root.right, root, k);
    }

    public int solve(Tree root, int k) {
        dfs(root, null, k);
        return ans;
    }
}
