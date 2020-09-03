package com.company.codingscales.leetcode.concepts.miscellaneous;

public class NumberCompliment {
    private String getBinary(int num) {
        final StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        int temp;
        while (num > 0) {
            temp = num % 2;
            sb.insert(0, temp);
            num = num / 2;
        }

        return sb.toString();
    }

    private int getDecimal(final String binary) {
        System.out.println(binary + " inside getDecima;");
        int res = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) != '0') {
                res += Math.pow(2, binary.length() - i - 1);
            }
        }

        System.out.println(res + "result");
        return res;
    }

    private String onesCompliment(final String binary) {
        final StringBuilder sb = new StringBuilder();

        for (final char ch : binary.toCharArray()) {
            sb.append(ch == '0' ? '1' : '0');
        }

        return sb.toString();
    }

    public int findComplement(final int num) {
        String binary = getBinary(num);
        System.out.println(binary + " before");
        binary = onesCompliment(binary);
        System.out.println(binary + " after");


        return getDecimal(binary);
    }

    public static void main(final String[] args) {
        final NumberCompliment nc = new NumberCompliment();
        System.out.println(nc.findComplement(5));
        System.out.println(nc.findComplement(2));
    }
}
