package com.company.codingscales.leetcode.concepts.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPostOrderAndInorder {
    private TreeNode recHelper(List<Integer> post, HashMap<Integer, Integer> valToIdxMap, int lo, int hi) {
        if (lo >= hi || post.isEmpty())
            return null;

        int val = post.remove(post.size() - 1);
        TreeNode root = new TreeNode(val);
        int index = valToIdxMap.get(val); // index inside

        root.right = recHelper(post, valToIdxMap, index + 1, hi);
        root.left = recHelper(post, valToIdxMap, lo, index);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> valToIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valToIdxMap.put(inorder[i], i);
        }

        List<Integer> post = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return recHelper(post, valToIdxMap, 0, postorder.length);
    }
}
