package com.company.codingscales.leetcode30DayChallenge;

public class ValidParenthesis {
    private static final char star = '*';
    private static final char open = '(';
    private static final char close = ')';

    private boolean recHelper(final char[] seq, final int idx, final int left, final int right) {
        if (idx == seq.length) {
            return left == right;
        }

        if (seq[idx] == star) {
            return recHelper(seq, idx + 1, left + 1, right) || recHelper(seq, idx + 1, left, right + 1) || recHelper(seq, idx + 1, left, right);
        }

        if (seq[idx] == open) {
            return recHelper(seq, idx + 1, left + 1, right);
        } else if (left > right && seq[idx] == close) {
            return recHelper(seq, idx + 1, left, right + 1);
        } else {
            return false;
        }
    }

    public boolean checkValidString(final String s) {
        final char[] seq = s.toCharArray();
        return recHelper(seq, 0, 0, 0);
    }
}

