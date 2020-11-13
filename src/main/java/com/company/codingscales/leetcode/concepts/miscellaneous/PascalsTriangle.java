package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (numRows == 1)
            return res;
        res.add(Arrays.asList(1, 1));
        if (numRows == 2)
            return res;


        for(int i = 3; i <= numRows; i++) {
            List<Integer> t = new ArrayList<>();
            for(int k = 0; k < i; k++)
                t.add(0);
            t.set(0, 1);
            t.set(i - 1, 1);

            List<Integer> prev = res.get(i - 2);
            for(int k = 1; k < i - 1; k++) {
                t.set(k, prev.get(k - 1) + prev.get(k));
            }

            res.add(t);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        System.out.println("Hello");
    }
}
