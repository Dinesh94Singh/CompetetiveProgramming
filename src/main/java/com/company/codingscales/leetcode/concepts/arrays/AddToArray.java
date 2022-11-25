package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddToArray {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        while (i >= 0 || k != 0) {

            int total = carry + (k == 0 ? 0 : k % 10) + (i >= 0 ? num[i] : 0);
            carry = total / 10;


            res.add(0, total % 10);
            k = k / 10;
            i--;
        }

        if (carry == 1)
            res.add(0, carry);

        return res;
    }
}
