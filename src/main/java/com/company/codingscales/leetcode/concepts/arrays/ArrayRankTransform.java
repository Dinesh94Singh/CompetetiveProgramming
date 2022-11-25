package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            copy[i] = arr[i];
        Arrays.sort(arr);
        HashMap<Integer, Integer> rank = new HashMap<>(); // cou

        for(int x : arr) {
            rank.putIfAbsent(x, rank.size() + 1);
        }

        int[] res = new int[arr.length];

        for(int i = 0; i < copy.length; i++)
            res[i] = rank.get(copy[i]);
        return res;
    }
}
