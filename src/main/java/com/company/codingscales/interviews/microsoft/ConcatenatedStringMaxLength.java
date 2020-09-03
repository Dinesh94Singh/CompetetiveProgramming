package com.company.codingscales.interviews.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatenatedStringMaxLength {
    static Integer maxLen;
    private static void recHelper(final List<String> arr, final String s, final int index) {
        if(index == arr.size()) {
            maxLen = Math.max(maxLen, s.length());
            if (maxLen == 26)
                System.out.println(s);
            return;
        }

        // Find out - single line code for this
        final HashSet<Character> hs = new HashSet<Character>();
        for(final char ch: s.toCharArray()) {
            hs.add(ch);
        }

        boolean duplicateFound = false;
        for(final char ch: arr.get(index).toCharArray()) {
            if (hs.contains(ch)) {
                duplicateFound = true;
                break;
            }
        }

        if(!duplicateFound) {
            recHelper(arr, s + arr.get(index), index + 1);
        }
        recHelper(arr, s, index + 1);
    }

    public static int maxLength(final List<String> arr) {
        maxLen = Integer.MIN_VALUE;
        final List<String> al = new ArrayList<>();
        final List<String> filteredAl = arr.stream().filter(e -> {
            final HashSet<Character> hs = new HashSet<Character>();
            for(final char ch: e.toCharArray()) {
                hs.add(ch);
            }
            return hs.size() == e.length();
        }).collect(Collectors.toList());

        recHelper(filteredAl, "", 0);
        return maxLen;
    }

    private int dpSolution(final List<String> A) {
        final List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (final String s : A) {
            int a = 0, dup = 0;
            for (final char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }
        return res;
    }
    public static void main(final String[] args) {
        final List<String> al = new ArrayList();
        al.add("yy");
        al.add("bkhwmpbiisbldzknpm");

        System.out.println(maxLength(al));
    }
}
