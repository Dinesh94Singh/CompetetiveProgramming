package com.company.codingscales.interviews.microsoft;

import java.util.*;

public class AirplaneSeats {
    private static int solve(final String s, final int n) {
        int res = 0;
        final String[] strs = s.split(" ");
        final Map<Integer, Set<Character>> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            map.put(i, new HashSet<>());
        }
        for(final String str : strs) {
            map.get(Integer.parseInt(str.substring(0, str.length() - 1))).add(str.charAt(str.length() - 1));
        }
        for(final Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            final Set<Character> set = entry.getValue();
            if(!set.contains('B') && !set.contains('C') && !set.contains('D') && !set.contains('E')) {
                res++;
                set.addAll(Arrays.asList('B', 'C', 'D', 'E'));
            }
            if(!set.contains('D') && !set.contains('E') && !set.contains('F') && !set.contains('G')) {
                res++;
                set.addAll(Arrays.asList('D', 'E', 'F', 'G'));
            }
            if(!set.contains('F') && !set.contains('G') && !set.contains('H') && !set.contains('J')) {
                res++;
                set.addAll(Arrays.asList('F', 'G', 'H', 'J'));
            }
        }
        return res;
    }

    public static void main(final String[] args) {
        System.out.println(solve("1A 2B", 2));
    }
}
