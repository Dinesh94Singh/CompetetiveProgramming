package com.company.codingscales.templates;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.company.codingscales.templates.LeetCodeInputHelpers.stringToIntArray;

public class ReadLines {
    public static void main(final String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line;
        while ((line = in.readLine()) != null) {
            final int[] nums = stringToIntArray(line);

        }

        final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/"));
        bufferedInputStream.read();
    }
}
