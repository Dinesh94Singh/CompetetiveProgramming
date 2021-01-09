package com.company.codingscales.leetcode.concepts.linkedList;

public class LinkedListCycleDetection {
    public static boolean hasCycle(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = head.next;

        while(t1 != null && t2 != null) {
            if (t1 == t2)
                return true;
            t1 = t1.next;
            t2 = t2.next != null ? t2.next.next : null;
        }

        return false;
    }
}
