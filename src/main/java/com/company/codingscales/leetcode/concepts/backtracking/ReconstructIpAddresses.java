package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReconstructIpAddresses {
    private int N;

    private boolean isValid(final String s) {
        if (s == null || s.isEmpty()) { return false; }
        if (s.length() >= 11) { return false; }
        final long i = Long.parseLong(s);
        return 0 <= i && i <= 255 && String.valueOf(i).equals(s);
    }

    private void recHelper(final int index, final String s, final int dots, final List<String> res, final List<String> al) {
        if (index == N) {
            return;
        }

        if (dots == 0) {
            if (isValid(s.substring(index))) {
                al.add(s.substring(index));
                res.add(al.stream().collect(Collectors.joining(".")));
                al.remove(al.size() - 1);
            }
            return;
        }

        for(int i = index + 1; i <= index + 4; i++) {
            if (isValid(s.substring(index, i))) {
                al.add(s.substring(index, i));
                recHelper(i, s, dots - 1, res, al);
                al.remove(al.size() - 1);
            }
        }
    }

    public List<String> restoreIpAddresses(final String s) {
        N = s.length();
        final int dots = 3;
        final List<String> res = new ArrayList<>();
        final List<String> al = new ArrayList<>();

        recHelper(0, s, dots, res, al);
        return res;
    }

    public static void main(String[] args) {
        ReconstructIpAddresses sol = new ReconstructIpAddresses();
        System.out.println(sol.restoreIpAddresses("25525511135"));
    }
}
