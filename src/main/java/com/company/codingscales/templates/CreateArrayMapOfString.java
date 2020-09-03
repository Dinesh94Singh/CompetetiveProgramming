package com.company.codingscales.templates;

public class CreateArrayMapOfString {
    int[] createArrayMap(final String p) {
        final int[] pArray = new int[256];

        for(final char ch: p.toCharArray())
            pArray[(int) ch] += 1;

        return pArray;
    }
}
