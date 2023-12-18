package com.company.codingscales.leetcode.concepts.strings;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int lastA = 0;
        int firstB = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                lastA = i;
            } else if (firstB == -1) {
                firstB = i;
            }
        }

        if (firstB > lastA) {
            return 0;
        }

        if (firstB == -1)
            return 0;

        int i = firstB;
        int aCount = 0;
        int bCount = 0;

        while (i <= lastA) {
            if (s.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }

            i++;
        }

        return Math.min(aCount, bCount);
    }

    public static void main(String[] args) {
        String s = "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa";
        MinimumDeletionsToMakeStringBalanced sol = new MinimumDeletionsToMakeStringBalanced();

        System.out.println(sol.minimumDeletions(s));
    }
}
