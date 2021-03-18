package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCombinationsOfPhoneNumber {
    HashMap<Integer, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put(2, Stream.of('a', 'b', 'c').collect(Collectors.toList()));
        map.put(3, Stream.of('d', 'e', 'f').collect(Collectors.toList()));
        map.put(4, Stream.of('g', 'h', 'i').collect(Collectors.toList()));
        map.put(5, Stream.of('j', 'k', 'l').collect(Collectors.toList()));
        map.put(6, Stream.of('m', 'n', 'o').collect(Collectors.toList()));
        map.put(7, Stream.of('p', 'q', 'r', 's').collect(Collectors.toList()));
        map.put(8, Stream.of('t', 'u', 'v').collect(Collectors.toList()));
        map.put(9, Stream.of('w', 'x', 'y', 'z').collect(Collectors.toList()));
        List<String> res = new ArrayList<>();
        dfs(digits, 0, res, new ArrayList<>());
        return res;
    }

    void dfs(String digits, int idx, List<String> res, List<Character> t) {
        if (idx == digits.length()) {
            StringBuilder sb = new StringBuilder();
            if (t.isEmpty())
                return;
            for (Character ch : t)
                sb.append(ch);
            res.add(sb.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(idx));
        for (Character ch : map.get(digit)) {
            t.add(ch);
            dfs(digits, idx + 1, res, t);
            t.remove(t.size() - 1);
        }
    }
}
