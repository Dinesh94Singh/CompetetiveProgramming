package com.company.codingscales.leetcode.concepts.trees;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBST {
    public void encoderHelper(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }

        al.add(root.val);
        encoderHelper(root.left, al);
        encoderHelper(root.right, al);
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> al = new ArrayList<>();
        encoderHelper(root, al);
        return al.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    static int index = 0;

    public TreeNode decoderHelper(String[] data, int lo, int hi) {
        if (data.length == index)
            return null;
        int x = Integer.parseInt(data[index]);
        if (x < lo || x > hi)
            return null;
        TreeNode curr = new TreeNode(x);
        index++;
        curr.left = decoderHelper(data, lo, x);
        curr.right = decoderHelper(data, x, hi);

        return curr;
    }

    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] words = data.split(",");
        System.out.println(words.length + " !! ");
        index = 0;
        return decoderHelper(words, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
