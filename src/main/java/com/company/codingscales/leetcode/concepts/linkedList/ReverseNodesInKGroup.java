package com.company.codingscales.leetcode.concepts.linkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int K) {
        ListNode p1 = head;
        int k = K;
        while (p1 != null && k >= 0) {
            p1 = p1.next;
            k--;
        }

        if (k > 0)
            return head;

        ListNode newHead = reverse(head, K);
        head.next = reverseKGroup(p1, K); // head becomes the tail
        return newHead;
    }

    ListNode reverse(ListNode head, int k) {
        ListNode p1 = head;
        ListNode prev = null;

        while (p1 != null && k >= 0) {
            ListNode next = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = next;
            k--;
        }

        return prev;
    }
}
