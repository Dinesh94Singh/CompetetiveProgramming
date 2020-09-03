package com.company.codingscales.leetcode.concepts.trees;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePath {
    private static void recHelper(final TreeNode root, final List<Integer> list, final List<String> res) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(list.stream().map(String::valueOf).collect(Collectors.joining("->")));
        } else {
            if (root.left != null)
                recHelper(root.left, list, res);
            if (root.right != null)
                recHelper(root.right, list, res);
        }
        list.remove(list.size() - 1); // remove the last element, prefer deque
    }

    public static List<String> binaryTreePaths(final TreeNode root) {
        if (root == null) return new ArrayList<String>();
        final List<String> res = new ArrayList<String>();

        recHelper(root, new ArrayList<Integer>(), res);
        return res;
    }

    public static void main(final String[] args) {
        System.out.println(binaryTreePaths(LeetCodeInputHelpers.stringToTreeNode("[1,2,3,null,5]")));
    }
}

