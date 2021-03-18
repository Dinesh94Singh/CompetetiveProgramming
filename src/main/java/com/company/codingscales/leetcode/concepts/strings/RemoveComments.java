package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.List;

//source = ["/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"]
//
//        The line by line code is visualized as below:
//        /*Test program */
//        int main()
//        {
//        // variable declaration
//        int a, b, c;
///* This is a test
//   multiline
//   comment for
//   testing */
//        a = b + c;
//        }
//
// Output: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
public class RemoveComments {
    public static List<String> removeComments(final String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        newline.replace(0, newline.length(), "");
        final List<String> ans = new ArrayList<>();
        for (final String line: source) {
            int i = 0;
            final char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}
