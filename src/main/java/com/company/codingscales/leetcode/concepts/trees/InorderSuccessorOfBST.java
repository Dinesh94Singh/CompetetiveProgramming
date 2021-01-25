package com.company.codingscales.leetcode.concepts.trees;

public class InorderSuccessorOfBST {
    public TreeNode inorderSuccessor(TreeNode root, final TreeNode p) {
        if (p.right != null) {
            TreeNode succ = p.right;
            while (succ.left != null)
                succ = succ.left;
            return succ;
        }

        /**
         * Using Stack
         *         Stack<TreeNode> st = new Stack<>();
         *
         *         while (root != null) {
         *             if (p.val < root.val) {
         *                 st.push(root);
         *                 root = root.left;
         *             } else if (p.val > root.val) {
         *                 root = root.right;
         *             } else if (p.val == root.val) {
         *                 if (st.isEmpty())
         *                     return null;
         *                 return st.peek();
         *             }
         *         }
         */

        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else if (p.val > root.val) { // if we are going left and if we go right, then the left one would not be the successor.
                root = root.right;
            } else break;
        }

        return succ;
    }

    public static void main(final String[] args) {
        final InorderSuccessorOfBST inorderSuccessorOfBST = new InorderSuccessorOfBST();
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(inorderSuccessorOfBST.inorderSuccessor(root, root.left).val);
    }
}
