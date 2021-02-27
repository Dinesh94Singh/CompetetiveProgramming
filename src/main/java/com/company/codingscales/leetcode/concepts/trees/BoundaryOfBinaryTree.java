package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {
    private void getLeft(TreeNode root, List<Integer> list) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!(curr.left == null && curr.right == null)) {
                list.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void getRight(TreeNode root, List<Integer> list) {
        TreeNode curr = root.right;
        while (curr != null) {
            if (!(curr.left == null && curr.right == null)) {
                list.add(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    private void getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            getLeaves(root.left, list);
            getLeaves(root.right, list);
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        if (root.left == null && root.right == null)
            return new ArrayList<>(root.val);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();

        List<Integer> res = new ArrayList<>(Collections.singletonList(root.val));
        getLeft(root, left);
        res.addAll(left);

        getLeaves(root, leaves);
        res.addAll(leaves);

        getRight(root, right);
        Collections.reverse(right);
        res.addAll(right);

        return res;
    }

    public static void main(String[] args) {
        BoundaryOfBinaryTree boundary = new BoundaryOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> res = boundary.boundaryOfBinaryTree(root);
        for(Integer each: res) {
            System.out.print("\t" + each);
        }
    }
}
