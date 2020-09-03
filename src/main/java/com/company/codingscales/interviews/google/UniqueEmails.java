package com.company.codingscales.interviews.google;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.HashSet;

public class UniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String email : emails) {
            String[] arr = email.split("@");
            String localName = arr[0];
            String domainName = arr[1];

            localName = localName.replace(".", "");
            int idx = localName.indexOf("+");
            sb.delete(0, sb.length());
            if (idx >= 0 && idx < localName.length()) {
                sb.append(localName.substring(0, idx));
            } else {
                sb.append(localName);
            }

            sb.append("@");
            sb.append(domainName);
            hs.add(sb.toString());
        }


        return hs.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(LeetCodeInputHelpers.stringToStringArray("[\"test.email+alex@leetcode.com\",\"test.e.mail+bob.cathy@leetcode.com\",\"testemail+david@lee.tcode.com\"]")));
    }
}
