package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstructBinarySearchTreeFromInorder {
    private TreeNode recHelper(final ArrayList<Integer> preorder, final int left, final int right, final HashMap<Integer, Integer> map) {
        if (preorder.isEmpty()) return null;
        if (preorder.get(0) > right || preorder.get(0) < left) return null;

        final TreeNode root = new TreeNode(preorder.remove(0));
        root.left = recHelper(preorder, left, root.val, map);
        root.right = recHelper(preorder, root.val, right, map);

        return root;

    }

    public TreeNode bstFromPreorder(final int[] preorder) {
        final ArrayList<Integer> al = new ArrayList<>();
        final HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < preorder.length; i++) {
            al.add(preorder[i]);
            hm.put(i, preorder[i]);
        }

        return recHelper(al, Integer.MIN_VALUE, Integer.MAX_VALUE, hm);
    }

    public static void main(final String[] args) {
        final ConstructBinarySearchTreeFromInorder c = new ConstructBinarySearchTreeFromInorder();
        final TreeNode r = c.bstFromPreorder(new int[]{8,5,1,7,10});
        System.out.println("Done !!");
    }
}
