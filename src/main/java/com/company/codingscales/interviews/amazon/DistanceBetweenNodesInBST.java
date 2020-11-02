package com.company.codingscales.interviews.amazon;

public class DistanceBetweenNodesInBST {
    // CREATE BST FROM LIST OF NUMS
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    private static TreeNode buildBST(TreeNode root, int node) {
        if (root == null) {
            root = new TreeNode(node);
            return root;
        } else if (root.val < node) {
            if (root.right == null)
                root.right = new TreeNode(node);
            else
                buildBST(root.right, node);
        } else if (root.val > node) {
            if (root.left == null)
                root.left = new TreeNode(node);
            else
                buildBST(root.left, node);
        }

        return root;
    }

    public static int findDistance(int[] nums, int i, int j) {
        TreeNode root = null;
        for(int k = 0; k < nums.length; k++) {
            root = buildBST(root, nums[k]);
        }

        TreeNode lca = findLCA(root, i, j);
        int distance = findDistanceFromLCA(lca, i) + findDistanceFromLCA(lca, j);
        return distance;
    }

    private static TreeNode findLCA(TreeNode root, int i, int j) {
        while (true) {
            if (root.val > i && root.val > j)
                root = root.left;
            else if (root.val < i && root.val < j)
                root = root.right;
            else
                return root;
        }
    }

    private static int findDistanceFromLCA(TreeNode lca, int i) {
        int distanceSum = 0;

        while (lca != null) {
            if (lca.val == i)
                return distanceSum;
            else if (lca.val < i) {
                distanceSum++;
                lca = lca.right;
            } else {
                distanceSum++;
                lca = lca.left;
            }
        }

        return distanceSum;
    }
}
