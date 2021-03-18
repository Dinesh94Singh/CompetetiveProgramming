package com.company.codingscales.leetcode.concepts.linkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        int k = 2;
        while (k > 0 && curr != null) {
            curr = curr.next;
            k--;
        }

        if (k > 0)
            return head; // cannot reverse, since odd count

        ListNode newHead = reverse(head, 2);
        head.next = swapPairs(curr);
        return newHead;
    }

    ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            k--;
        }

        return prev;
    }
}
