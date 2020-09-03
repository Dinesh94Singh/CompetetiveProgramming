package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SerializeAndDeserializeBST {
    String serialize(final int[] arr) {
       return null;
    }

    private TreeNode recHelper(final int left, final int right, final ArrayDeque<Integer> arrayDeque) {
        if (arrayDeque.isEmpty())
            return null;
        if (arrayDeque.peekLast() < left || arrayDeque.peekLast() > right)
            return null;

        final Integer val = arrayDeque.removeLast();
        final TreeNode node = new TreeNode(val);

        node.right = recHelper(val, right, arrayDeque);
        node.left = recHelper(left, val, arrayDeque);
        return node;
    }

    TreeNode deserialize(final Integer[] arr) {
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(arr));
        return recHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, deque);
    }

    TreeNode deserialize(final String serializedData) {
        final String[] data = serializedData.split(",");
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(final String s: data) {
            deque.add(Integer.parseInt(s));
        }
        return recHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, deque);
    }
}
