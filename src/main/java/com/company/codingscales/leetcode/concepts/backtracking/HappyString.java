package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class HappyString {
    private void recHelper(final int n, final ArrayList<String> al, final ArrayList<String> res) {
        if (n == 0) {
            final StringBuilder r = new StringBuilder();
            for(final String s : al) {
                r.append(s);
            }
            res.add(r.toString());
            return;
        }
        final String s = "abc";
        final int size = al.size();
        for (final char ch: s.toCharArray()) {
            if (size == 0 || al.get(size - 1).indexOf(ch) == -1) {
                al.add("" + ch);
                recHelper(n-1, al, res);
                al.remove(size);
            }
        }
    }

    public String getHappyString(final int n, final int k) {
        final ArrayList<String> res = new ArrayList<>();
        recHelper(n, new ArrayList<String>(), res);
        Collections.sort(res);
        if (res.isEmpty() || res.size() < k) return "";
        return res.get(k - 1);
    }
}
