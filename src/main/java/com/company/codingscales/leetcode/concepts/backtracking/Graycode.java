package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graycode {
    int n;
    Set<Integer> history;
    public List<Integer> grayCode(int n) {
        if (n == 0)
            return new ArrayList<>();
        this.n = n;
        history = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);

        dfs(res);
        return res;
    }

    private static boolean isValid(int x, int y) {
        final int xor = x ^ y;
        if (xor == 0) { // both are same
            return false;
        }
        return (xor & (xor - 1)) == 0; // both differ by only 1
    }

    private boolean dfs(final List<Integer> res) {
        if (res.size() == 1 << n) { // you cannot have 1111 (for 4 bits, the numbers 0000 - 0001 - 0011 - 0010 -
            return isValid(res.get(0), res.get(res.size() - 1));
        }

        for(int i = 0; i < n; i++) {
            final int prev = res.get(res.size() - 1);
            final int candidate = prev ^ (1 << i); // if u look at above comment, based on prev value we are trying to )

            if (!history.contains(candidate)) {
                history.add(candidate);
                res.add(candidate);
                if (dfs(res)) {
                    return true;
                }
                history.remove(candidate);
                res.remove(res.size() - 1);
            }
        }

        return false;
    }
}
