package com.company.codingscales.interviews.microsoft;

import java.util.HashMap;

public class DayOfWeek {
    private static String solve(final String s, final int k) {
        final HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Sun", 0);
        hm.put("Mon", 1);
        hm.put("Tue", 2);
        hm.put("Wed", 3);
        hm.put("Thu", 4);
        hm.put("Fri", 5);
        hm.put("Sat", 6);

        final HashMap<Integer, String> reverseMap = new HashMap<>();
        reverseMap.put(0, "Sun");
        reverseMap.put(1, "Mon");
        reverseMap.put(2, "Tue");
        reverseMap.put(3, "Wed");
        reverseMap.put(4, "Thu");
        reverseMap.put(5, "Fri");
        reverseMap.put(6, "Sat");

        return reverseMap.get((hm.get(s) + k) % 7);

    }
    public static void main(final String[] args) {
        System.out.println(solve("Wed", 2));
        System.out.println(solve("Sat", 23));
    }
}
