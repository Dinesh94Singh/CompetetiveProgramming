package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int numRows) {
        numRows++;
        if (numRows == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        if (numRows == 1)
            return res.get(0);
        res.add(Arrays.asList(1, 1));
        if (numRows == 2)
            return res.get(1);

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

        return res.get(res.size() - 1);
    }
}
