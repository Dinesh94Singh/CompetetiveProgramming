package com.company.codingscales.leetcode.concepts.trees;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayList;

public class ConstructBinarySearchTreeFromPreOrderTraversal {
    private TreeNode recHelper(ArrayList<Integer> preorder, int left, int right) {
        if (preorder.isEmpty()) return null;
        if (preorder.get(0) > right || preorder.get(0) < left) return null;

        TreeNode root = new TreeNode(preorder.remove(0));
        root.left = recHelper(preorder, left, root.val);
        root.right = recHelper(preorder, root.val, right);

        return root;

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < preorder.length; i++)
            al.add(preorder[i]);

        return recHelper(al, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreOrderTraversal sol = new ConstructBinarySearchTreeFromPreOrderTraversal();
        TreeNode root = sol.bstFromPreorder(LeetCodeInputHelpers.stringToIntArray("[8,5,1,7,10,12]"));
        System.out.println(root);
    }
}
