package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NextClosestTime {
    // 4 * 4 * 4 * 4 = 256 poss
    String result = "";
    int diff = Integer.MAX_VALUE;

    public String nextClosestTime(final String time) {
        final String[] times = time.split(":");
        final String hours = times[0];
        final String minutes = times[1];

        final HashSet<Integer> allowedChars = new HashSet<>();
        for(final char ch : time.toCharArray()) {
            if (ch != ':')
                allowedChars.add(ch - '0');
        }


        if (allowedChars.size() == 1)
            return time;

        final List<Integer> digits = new ArrayList<>(allowedChars);
        final int minute = Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);

        dfs(digits, "", 0, minute);

        return result;
    }

    private void dfs(final List<Integer> digits, final String cur, final int pos, final int target) {
        if (pos == 4) {
            final int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (m == target) return;
            final int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2) continue;
            if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) continue;
            if (pos == 2 && digits.get(i) > 5) continue;
            if (pos == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59) continue;
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }
}
