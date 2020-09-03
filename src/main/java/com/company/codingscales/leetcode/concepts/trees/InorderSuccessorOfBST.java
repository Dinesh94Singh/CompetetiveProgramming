package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;

public class InorderSuccessorOfBST {
    public TreeNode inorderSuccessor(final TreeNode root, final TreeNode p) {
        // you need parent info
        if (root == null) return null;
        if (root.val == p.val) return null;

        final ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        deque.addLast(curr);
        while (curr != null) {
            if (curr.val < p.val) {
                deque.addLast(curr);
                curr = curr.right;
            } else if (curr.val > p.val) {
                deque.addLast(curr);
                curr = curr.left;
            } else {
                if (curr.right != null) {
                    TreeNode succ = curr.right;
                    while (succ.left != null) {
                        succ = succ.left;
                    }
                    return succ;
                } else {
                    while(!deque.isEmpty()) {
                        final TreeNode top = deque.peekLast();
                        if (top.left != null && top.left.val == p.val) {
                            return top;
                        }
                        if (top.right == null || top.right.val == p.val || top.val < p.val)
                            deque.removeLast();
                        else
                            break;
                    }
                    if (deque.isEmpty())
                        return null;
                    return deque.peekLast();
                }
            }
        }
        return null;
    }

    public static void main(final String[] args) {
        final InorderSuccessorOfBST inorderSuccessorOfBST = new InorderSuccessorOfBST();
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(inorderSuccessorOfBST.inorderSuccessor(root, root.left).val);
    }
}
