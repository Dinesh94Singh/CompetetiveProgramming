package com.company.codingscales.leetcode.concepts.strings;

public class ValidateIPAddress {
    private static final String IPV4 = "IPV4";
    private static final String IPV6 = "IPV6";
    private static final String NEITHER = "NEITHER";

    public String validIPAddress(final String IP) {
        final boolean isIPV4 = IP.contains(".");

        if (isIPV4) {
            final String[] segments = IP.split("\\.");
            if (segments.length != 3) return NEITHER;

            for(final String s: segments) {
                if (!String.valueOf(Integer.parseInt(s)).equals(s) || Integer.parseInt(s) >= 255)
                    return NEITHER;
            }
            return IPV4;
        } else {
            final String[] segments = IP.split(":");

            if (segments.length != 8) return NEITHER;
            for(final String s: segments) {
                if (Integer.parseInt(s, 16) >= 255)
                    return NEITHER;
            }
            return IPV6;
        }
    }

    public static void main(final String[] args) {
        final ValidateIPAddress validateIPAddress = new ValidateIPAddress();
        // validateIPAddress.validIPAddress("192.132.68.32");
        // validateIPAddress.validIPAddress("192:132:68:32");
//        System.out.println(validateIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validateIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
