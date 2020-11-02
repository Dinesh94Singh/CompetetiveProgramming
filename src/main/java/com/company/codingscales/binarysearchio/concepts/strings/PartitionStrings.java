package com.company.codingscales.binarysearchio.concepts.strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Similar to Sliding Window
public class PartitionStrings {
    public static int[] solve(String s) {
        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> cnt = new HashMap<>();
        int size = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            size++;
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
            boolean ok = true;

            for(char key : cnt.keySet()) { // O(26)
                if (!cnt.get(key).equals(hm.get(key)))
                    ok = false;
            }

            if (ok) {
                for (char key : cnt.keySet()) {
                    hm.put(key, 0); // everything has been added
                }

                res.add(size); // add to result

                cnt = new HashMap<>(); // reset
                size = 0; // reset
            }
        }

        if (size != 0)
            res.add(size);

        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = solve("cocoplaydae");

        for(int i = 0; i < res.length; i++)
            System.out.printf("%d \t", res[i]);
    }
}
