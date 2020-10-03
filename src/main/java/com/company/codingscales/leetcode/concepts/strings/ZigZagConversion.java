package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int start = 0;
        int end = numRows - 2;
        int j = 0;
        while (j < s.length()) {
            for(int i = start; i < numRows && j < s.length(); i++) {
                StringBuilder sb = list.get(i);
                sb.append(s.charAt(j++));
            }

            for(int i = end; i >= 0 && j < s.length(); i--) {
                StringBuilder sb = list.get(i);
                sb.append(s.charAt(j++));
            }

            start = 1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) {
            res.append(sb.toString());
        }

        return res.toString();
    }
}
