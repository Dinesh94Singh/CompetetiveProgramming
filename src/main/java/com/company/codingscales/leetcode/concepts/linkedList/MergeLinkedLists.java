package com.company.codingscales.leetcode.concepts.linkedList;

public class MergeLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode prev = new ListNode();
        ListNode head = prev;

        while(t1 != null || t2 != null) {
            if (t1 == null) {
                prev.next = t2;
                break;
            } else if (t2 == null) {
                prev.next = t1;
                break;
            } else {
                if (t1.val < t2.val) {
                    prev.next = t1;
                    t1 = t1.next;
                } else {
                    prev.next = t2;
                    t2 = t2.next;
                }
            }

            prev = prev.next;
        }

        return head.next;
    }
}
