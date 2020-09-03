package com.company.codingscales.leetcode.concepts.trees;

public class DeleteNodeInBST {
    private TreeNode getSuccessor(TreeNode node) {
        // left subtree's left node
        /* Deleting 50 => find the succ => 55 (right subtrees left most node)
           succ of 3 is None, you delete the node directly
                        4
                  2             50
               1      3              77
                                55
                            53     56
         */

        TreeNode succ = node.right;
        if (succ == null) return null;
        while (succ.left != null) {
            succ = succ.left;
        }
        return succ;
    }

    private TreeNode getPredecessor(TreeNode node) {
        // left subtree's left node
        /* Deleting 50 => find the succ => 55 (right subtrees left most node)
           succ of 3 is None, you delete the node directly
                        4
                  2             50
               1      3              77
                                55
                            53     56
         */

        TreeNode pred = node.left;
        if(pred == null) return null;
        while (pred.right != null) {
            pred = pred.right;
        }
        return pred;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.right != null) {
                TreeNode succ = getSuccessor(root);
                root.val = succ.val;
                root.right = deleteNode(root.right, succ.val);
            } else {
                TreeNode pred = getPredecessor(root);
                root.val = pred.val;
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }

    public static void main(final String[] args) {
        final TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        final DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();
        deleteNodeInBST.deleteNode(root, 4);
        System.out.println(root);
    }
}
