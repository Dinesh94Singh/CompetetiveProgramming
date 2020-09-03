package com.company.codingscales.leetcode.concepts.strings;

public class LicenseKeyFormatting {
    /**
     * Issues with this code is -> Unnecessary StringBuilder object creations
     * Reversing each time => O(n) + O(K)
     * O(n) for finding the first index of - if starting with -'s
     *
     * Things to remember during coding interview
     * Space Complexity & Time Complexity
     */
    public String licenseKeyFormattingBadWay(String S, int K) {
        S = S.replace("-", "");
        StringBuilder sb = new StringBuilder(S);
        sb.reverse(); // 5F3Z2e9w => w9e2z3F5

        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < sb.length()) {
            String sub = sb.substring(i, Math.min(i + K, sb.length()));
            res.insert(0, new StringBuilder(sub).reverse()); // => 2e9w
            res.insert(0, "-");
            i += K; // exclusive, so i would be at the right place
        }

        i = 0;
        while (i < res.length()) {
            if (res.charAt(i) != '-') {
                break;
            }
            i++;
        }

        return res.substring(i);
    }

    public String licenseKeyFormatting(String S, int K) {
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=n-1; i>=0; i--) {
            if (S.charAt(i) == '-'){
                continue;
            }

            if (cnt == K){
                sb.append("-");
                cnt = 0;
            }
            sb.append(Character.toUpperCase(S.charAt(i)));
            cnt++;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting formatting = new LicenseKeyFormatting();
        System.out.println(formatting.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(formatting.licenseKeyFormatting("2-5g-3-J", 2));
    }
}
