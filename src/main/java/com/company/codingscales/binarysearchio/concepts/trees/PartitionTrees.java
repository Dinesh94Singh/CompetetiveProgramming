package com.company.codingscales.binarysearchio.concepts.trees;

public class PartitionTrees {
    int leaves = 0;
    int nodes = 0;

    private void dfs(Tree root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            leaves++;
        }

        nodes++;
        dfs(root.left);
        dfs(root.right);
    }

    public int[] solve(Tree root) {
        dfs(root);
        return new int[]{leaves, nodes - leaves};
    }
}
