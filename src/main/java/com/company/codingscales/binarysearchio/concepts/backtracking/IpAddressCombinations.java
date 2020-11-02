package com.company.codingscales.binarysearchio.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IpAddressCombinations {
    List<String> res;

    private boolean valid(String s) {
        if (s.isEmpty())
            return false;

        int x = Integer.parseInt(s);

        if (s.length() > 3)
            return false;

        if (x < 0 || x > 255) {
            return false;
        }

        String S = String.valueOf(x);

        return S.length() == s.length();
    }

    private void dfs(int index, List<String> t, String ip, int dots) {
        if (dots == 0) {
            if(valid(ip.substring(index))) {
                t.add(ip.substring(index));
                res.add(t.stream().map(String::valueOf).collect(Collectors.joining(".")));
                t.remove(t.size() - 1);
            }
            return;
        }

        for(int i = index + 1; i < Math.min(ip.length(), index + 4); i++) {
            String s = ip.substring(index, i);
            if (valid(s)) {
                t.add(s);
                dfs(i, t, ip, dots - 1);
                t.remove(t.size() - 1);
            }
        }
    }

    public String[] solve(String ip) {
        res = new ArrayList<>();
        int dots = 3;
        ArrayList<String> t = new ArrayList<>();
        dfs(0, t, ip, dots);
        String[] ret = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        IpAddressCombinations sol = new IpAddressCombinations();
        sol.solve("2542540123");
    }
}
