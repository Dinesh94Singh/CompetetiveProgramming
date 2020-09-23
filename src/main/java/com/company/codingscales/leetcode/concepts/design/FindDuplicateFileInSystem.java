package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-file-in-system/discuss/104123/C%2B%2B-clean-solution-answers-to-follow-up
public class FindDuplicateFileInSystem {
    /**
     * Imagine you are given a real file system, how will you search files? DFS or BFS? => Shouldn't matter much. BFS would extra memory, BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster, like showcased in the code. DFS would be optimal in ideal cases as well because, usually the max depth of file system doesn't exceed more than 20 depth.
     *
     * If the file content is very large (GB level), how will you modify your solution? => Create CheckSums MD5 or SHA-256 if using Hashmap
     *
     * Most consuming TC/SC of the algorithm => Comparing file contents each time -> Only if the md5 is the same, we will compare the files byte by byte
     *
     * If you can only read the file by 1kb each time, how will you modify your solution? => Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size. TC doesn't change, since, we can consider MD5 generation as constant algorithm
     *
     * How to make sure the duplicated files you find are not false positive? Filers like File size -> Hash -> byte by byte comparisons.
     */
    public static List<List<String>> findDuplicate(final String[] paths) {
        final HashMap<String, List<String>> fileSystem  = new HashMap<>();
        for(final String each : paths) {
            final String[] path = each.split("\\s+");
            final String directory = path[0];
            for(int i = 1; i < path.length; i++) {
                final int index = path[i].indexOf("(");
                final String content = path[i].substring(index + 1, path[i].length() - 1); // remove the closing parenthesis

                fileSystem.putIfAbsent(content, new ArrayList<>());
                final StringBuilder sb = new StringBuilder();
                sb.append(directory);
                sb.append("/");
                sb.append(path[i].substring(0, index));
                fileSystem.get(content).add(sb.toString());
            }
        }

        final List<List<String>> res = new ArrayList<>();
        for(final Map.Entry<String, List<String>> entry : fileSystem.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }

        return res;
    }

    public static void main(final String[] args) {
        final String[] input = {"root/a 1.txt(abcd) 2.txt(efsfgh) 3.txt(efsfgh)","root/c 3.txt(efsfgh)","root/c/d 4.txt(efggdfh)"};
        final List<List<String>> res = findDuplicate(input);
        for(final List<String> each : res) {
            for(final String e : each) {
                System.out.printf("%s \t", e);
            }
            System.out.println();
        }
    }
}
