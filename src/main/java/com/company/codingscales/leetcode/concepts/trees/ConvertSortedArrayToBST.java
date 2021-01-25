package com.company.codingscales.leetcode.concepts.trees;

public class ConvertSortedArrayToBST {
    TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + (hi - lo) / 2);

        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(nums, lo, mid - 1);
        node.right = dfs(nums, mid + 1, hi);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return dfs(nums, 0, nums.length - 1);
    }
}
