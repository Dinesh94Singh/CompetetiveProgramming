package com.company.codingscales.leetcode.concepts.bitmap;

import java.util.*;
import com.company.codingscales.leetcode.concepts.trees.*;

/**
 * PsuedoPalindromicPathsInABinaryTree
 */
public class PsuedoPalindromicPathsInABinaryTree {

    class PsuedoPalindromicPathsInABinaryTreeWithoutBitManipulation {
        int count = 0;

        public int pseudoPalindromicPaths (TreeNode root) {
            dfs(root, new ArrayList<>());
            return count;
        }

        private boolean psuedo_pallindrome(List<Integer> l) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int each : l) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }

            boolean found_odd = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    if (found_odd) {
                        return false;
                    }

                    found_odd = true;
                }
            }

            return true;
        }

        private void dfs(TreeNode root, ArrayList<Integer> list) {
            if (root == null)
                return;

            if (root != null && root.left == null && root.right == null) {
                list.add(root.val);

                if (psuedo_pallindrome(list)) {
                    count++;
                }

                list.remove(list.size() - 1);

                return;
            }

            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
            list.remove(list.size() - 1);
        }
    }


    // ----------------------------- BitManipulation apporach ----------------
    //
    // Given only 9 numbers will atmost be there in the Tree
    // 1 << 10 would have a bit for all numbers

    // ex 1 = 000000001
    // ex 2 = 000000010

    // To get the freq map - we can xor to see if it is odd or even

    // How to check the last set bit - mask & (mask - 1)
    class PsuedoPalindromicPathsInABinaryTreeBitManipulation {
        int count = 0;

        public int psuedoPalindromicPaths(TreeNode root) {
            dfs(root, 0);
            return count;
        }

        private void dfs(TreeNode root, int path) {
            if (root != null) {
                path = path ^ (1 << root.val);

                if (root.left != null && root.right != null) {
                    if ((path & (path - 1)) == 0) {
                        ++count;
                    }

                    return;
                }

                dfs(root.left, path);
                dfs(root.right, path);
            }
        }
    }
}
