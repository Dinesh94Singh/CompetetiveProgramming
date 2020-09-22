package com.company.codingscales.interviews.amazon;

import java.util.*;

public class TransactionLogs {
    public static List<String> processLogs(final List<String> logs, final int threshold) {
        List<String> res = new ArrayList<>();
        final TreeMap<Long, Integer> counter = new TreeMap<>();
        for (final String each : logs) {
            final String[] elements = each.split("\\s+");
            final Long src = Long.valueOf(elements[0]);
            final Long dest = Long.valueOf(elements[1]);

            if (!src.equals(dest)) {
                counter.put(src, counter.getOrDefault(src, 0) + 1);
                counter.put(dest, counter.getOrDefault(dest, 0) + 1);
            } else {
                counter.put(src, counter.getOrDefault(src, 0) + 1);
            }
        }

        for(final Map.Entry<Long, Integer> entry : counter.entrySet()) {
           if (entry.getValue() >= threshold)  {
               res.add(String.valueOf(entry.getKey()));
           }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        List<String> input = Arrays.asList(arr);
        for(final String each : processLogs(input, 2)) {
            System.out.println(each);
        }
    }
}

