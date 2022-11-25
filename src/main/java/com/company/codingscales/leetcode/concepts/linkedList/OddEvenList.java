package com.company.codingscales.leetcode.concepts.linkedList;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();

        ListNode newHead = odd;
        ListNode dummy = even;

        ListNode curr = head;

        while (curr != null) {
            odd.next = curr;
            even.next = curr.next;

            odd = odd.next;
            even = even.next;
            curr = curr.next != null ? curr.next.next : null;
        }

        odd.next = dummy.next;

        return newHead.next;
    }

    class SolutionRedo {
        public ListNode oddEvenList(ListNode head) {
            if (head == null)
                return null;
            ListNode even = head.next;

            ListNode t1 = head;
            ListNode t2 = head.next;
            ListNode prev = null;

            while (t2 != null) {
                t1.next = t1.next != null ? t1.next.next : null;
                t2.next = t2.next != null ? t2.next.next : null;

                prev = t1;

                t1 = t1.next;
                t2 = t2.next;
            }

            if (t1 == null)
                prev.next = even;
            else
                t1.next = even;

            return head;
        }
    }
}
