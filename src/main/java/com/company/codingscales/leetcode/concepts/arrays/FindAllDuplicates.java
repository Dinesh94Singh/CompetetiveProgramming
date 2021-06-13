package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] A) {
        List<Integer> res = new ArrayList<>();

        for(int a : A) {
            A[Math.abs(a) - 1] *= -1;
        }

        for(int a : A) {
            if (A[Math.abs(a) - 1] > 0) {
                res.add(Math.abs(a));
                A[Math.abs(a) - 1] *= -1;
            }
        }

        return res;
    }
}
