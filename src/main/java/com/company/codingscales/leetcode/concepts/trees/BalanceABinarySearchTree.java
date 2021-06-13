package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    static class BalanceBinarySearchTreeWithoutRecursion {
        public TreeNode balanceBST(TreeNode root) {
            TreeNode pseudoRoot = new TreeNode(0);
            pseudoRoot.right = root;

            int nodeCount = flattenTreeWithRightRotations(pseudoRoot);
            int heightOfTree = (int)(Math.log(nodeCount + 1) / Math.log(2));
            int numOfNodesInTree = (int) Math.pow(2, heightOfTree) - 1;

            createBalancedTreeWithLeftRotation(pseudoRoot, nodeCount - numOfNodesInTree);
            for (int numOfNodesInSubTree = (numOfNodesInTree/2); numOfNodesInSubTree > 0; numOfNodesInSubTree /= 2)
                createBalancedTreeWithLeftRotation(pseudoRoot, numOfNodesInSubTree);
            return pseudoRoot.right;
        }

        // Inorder Morris Traversal'
        public static FlattenBinaryTree.TreeNode flattenUsingMorrisTraversal(FlattenBinaryTree.TreeNode root) {
            FlattenBinaryTree.TreeNode head = new FlattenBinaryTree.TreeNode();
            FlattenBinaryTree.TreeNode tail = head;

            FlattenBinaryTree.TreeNode curr = root;
            FlattenBinaryTree.TreeNode pred;

            while (curr != null) {

                if (curr.left != null) {
                    pred = curr.left;

                    while (pred.right != null && pred.right != curr) {
                        pred = pred.right;
                    }

                    if (pred.right == null) {
                        pred.right = curr;
                        curr = curr.right;
                    } else { // Ideally in morris traversal we would say print(curr.val); pred.right = null; curr = curr.right;
                        tail.right = curr;
                        curr.left = tail; // remove this for balance a binary search tree ?
                        tail = tail.right;
                        curr = curr.right;
                    }
                } else { // ideally in morris traversal we would say print(curr.val); curr = curr.right;
                    tail.right = curr;
                    curr.left = tail; // remove this for balance a binary search tree?
                    tail = tail.right;
                    curr = curr.right;
                }

            }

            head.right.left = tail;
            tail.left = head.right;

            return head.right;
        }

        // use above to flatten
        public int flattenTreeWithRightRotations(TreeNode root) {
            int nodeCount = 0;
            TreeNode pseudoRoot = root.right;
            while (pseudoRoot != null) {
                if (pseudoRoot.left != null) {
                    TreeNode oldPseudoRoot = pseudoRoot;
                    pseudoRoot = pseudoRoot.left;
                    oldPseudoRoot.left = pseudoRoot.right;
                    pseudoRoot.right = oldPseudoRoot;
                    root.right = pseudoRoot;
                } else {
                    ++nodeCount;
                    root = pseudoRoot;
                    pseudoRoot = pseudoRoot.right;
                }
            }
            return nodeCount;
        }

        void createBalancedTreeWithLeftRotation(TreeNode auxRoot, int n) {
            TreeNode root = auxRoot.right;
            while (n-- > 0) {
                TreeNode oldRoot = root;
                root = root.right;

                auxRoot.right = root;
                oldRoot.right = root.left;
                root.left = oldRoot;
                auxRoot = root;
                root = root.right;
            }
        }
    }


    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);

        return dfs2(0, list.size() - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode dfs2(int lo, int hi, int lo_bound, int hi_bound) {
        if (lo > hi)
            return null;


        int mid = (lo + (hi - lo) / 2);
        int val = list.get(mid);

        if (!(lo_bound <= val && val <= hi_bound)) {
            return null;
        }

        TreeNode curr = new TreeNode(val);
        curr.left = dfs2(lo, mid - 1, lo_bound, val);
        curr.right = dfs2(mid + 1, hi, val, hi_bound);

        return curr;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
