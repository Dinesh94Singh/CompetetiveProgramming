package com.company.codingscales.templates;

import com.company.codingscales.leetcode.concepts.trees.TreeNode;
import com.eclipsesource.json.JsonArray;

import java.util.*;


public class LeetCodeInputHelpers {
    public static int[] stringToIntArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.isEmpty()) {
            return new int[0];
        }

        final String[] parts = input.split(",");
        final int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            final String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static TreeNode stringToTreeNode(String input){
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.isEmpty()) {
            return null;
        }

        final String[] parts = input.split(",");
        String item = parts[0];
        final TreeNode root = new TreeNode(Integer.parseInt(item));
        final Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            final TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                final int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                final int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static int[][] stringToInt2dArray(final String input) {
        final JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.isEmpty()) {
            return new int[0][0];
        }

        final int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            final JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntArray(cols.toString());
        }
        return arr;
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static List<String> stringToStringList(String s) {
        return Arrays.asList(stringToStringArray(s));
    }

    public static List<List<String>> stringToString2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.isEmpty()) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToStringList(cols.toString()));
        }
        return list;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
}
