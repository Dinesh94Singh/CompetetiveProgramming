package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIPAddress {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(0, s, 3, new ArrayList<>());
        return res;
    }

    void dfs(int idx, String s, int dots, List<String> l) {

        if (dots == 0) {
            String t = s.substring(idx);

            if (t.isEmpty() || t.length() > 3)
                return;

            int n = Integer.parseInt(t);
            if (n >= 0 && n <= 255 && t.length() == String.valueOf(n).length()) {
                l.add(t);
                res.add(l.stream().collect(Collectors.joining(".")));
                l.remove(l.size() - 1);
            }

            return;
        }


        for(int i = idx + 1; i < Math.min(s.length(), idx + 4); i++) {
            String k = s.substring(idx, i);
            int t = Integer.parseInt(k);
            if (t >= 0 && t <= 255 && k.length() == String.valueOf(t).length()) {
                l.add(k);
                dfs(i, s, dots - 1, l);
                l.remove(l.size() - 1);
            }
        }
    }


}
