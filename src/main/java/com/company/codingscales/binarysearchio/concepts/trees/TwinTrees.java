package com.company.codingscales.binarysearchio.concepts.trees;

public class TwinTrees {
    private boolean dfs(Tree root1, Tree root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);

        return left && right && root1.val == root2.val;
    }

    public boolean solve(Tree root0, Tree root1) {
        return dfs(root0, root1);
    }
}
