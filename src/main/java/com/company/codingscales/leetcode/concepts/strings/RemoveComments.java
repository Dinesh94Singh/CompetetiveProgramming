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
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for(String line : source) {
            int i = 0;
            if (!inBlock) {
                sb.replace(0, sb.length(), "");
            }

            while(i < line.length()) {
                String t = i < line.length() - 1 ? line.substring(i, i + 2) : "";
                if (!inBlock && t.equals("//")) {
                    break;
                } else if (t.equals("/*") && !inBlock) {
                    inBlock = true;
                    i += 2;
                } else if (t.equals("*/") && inBlock) {
                    inBlock = false;
                    i += 2;
                } else if (!inBlock) {
                    sb.append(line.charAt(i));
                    i += 1;
                } else {
                    i += 1; // continue exploring
                }
            }

            if (inBlock || sb.length() == 0)
                continue;
            res.add(sb.toString());
        }

        return res;
    }
}
