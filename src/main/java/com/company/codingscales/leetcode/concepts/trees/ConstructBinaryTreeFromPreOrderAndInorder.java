package com.company.codingscales.leetcode.concepts.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreOrderAndInorder {
    // root, left, right => removeFirst();
    // left, root, right
    private TreeNode recHelper(List<Integer> pre, HashMap<Integer, Integer> valToIdxMap, int lo, int hi) {
        if (lo >= hi || pre.size() == 0)
            return null;

        int val = pre.remove(0);
        TreeNode root = new TreeNode(val);
        int index = valToIdxMap.get(val); // index inside

        root.left = recHelper(pre, valToIdxMap, lo, index);
        root.right = recHelper(pre, valToIdxMap, index + 1, hi);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> valToIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIdxMap.put(inorder[i], i);
        }

        List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());

        return recHelper(pre, valToIdxMap, 0, preorder.length);
    }
};