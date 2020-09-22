package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(final List<String> strs) {
        final StringBuilder sb = new StringBuilder();
        for(final String each : strs) {
            sb.append(each.length());
            sb.append(".");
            sb.append(each);
        }

        return sb.toString();
    }

    public List<String> decode(final String s) {
        int i = 0;
        int n = 0;
        final List<String> res = new ArrayList<>();
        while (i < s.length()) {
            final char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
                i++;
            } else {
                // i is the dot
                res.add(s.substring(i + 1, i + n + 1));
                i += n + 1;
                n = 0;
            }
        }

        return res;
    }
}
