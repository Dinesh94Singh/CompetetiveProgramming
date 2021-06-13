package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digitLogs = new ArrayList<>();
        ArrayList<String> letterLogs = new ArrayList<>();

        for(String log : logs) {
            String[] words = log.split(" ");

            if (Character.isDigit(words[1].charAt(0))){
                // digit log
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((a, b) -> {
            int i = a.indexOf(" ");
            int j = b.indexOf(" ");

            String s1 = a.substring(i + 1);
            String s2 = b.substring(j + 1);

            int t = s1.compareTo(s2);
            if (t == 0)
                return a.split(" ")[0].compareTo(b.split(" ")[0]);
            return t;
        });

        String[] res = new String[letterLogs.size() + digitLogs.size()];
        int k = 0;
        for(int i = 0; i < letterLogs.size(); i++) {
            res[k++] = letterLogs.get(i);
        }

        for(int i = 0; i < digitLogs.size(); i++) {
            res[k++] = digitLogs.get(i);
        }

        return res;
    }
}
