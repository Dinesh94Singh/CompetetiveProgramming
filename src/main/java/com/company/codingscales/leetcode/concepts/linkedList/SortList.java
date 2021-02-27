package com.company.codingscales.leetcode.concepts.linkedList;

public class SortList {
    private ListNode divideAndConquer(ListNode head) {
        if (head == null || head.next == null)
            return head;
        System.out.println(head.val);
        ListNode mid = getMid(head);
        ListNode left = divideAndConquer(head);
        ListNode right = divideAndConquer(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode t1, ListNode t2) {
        // merge two sorted list code
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                prev.next = t1;
                prev = t1;
                t1 = t1.next;
            } else {
                prev.next = t2;
                prev = t2;
                t2 = t2.next;
            }
        }

        prev.next = (t1 != null) ? t1 : t2;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        return divideAndConquer(head);
    }

    private ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;

        // ListNode t1 = head;
        // ListNode t2 = head.next;
        // ListNode prev = null;
        //
        // while (t2 != null && t2.next != null) {
        //     prev = t1;
        //     t1 = t1.next;
        //     t2 = t2.next.next;
        // }
        //
        // if (prev != null)
        //     prev.next = null;
        // return t1;
    }
}
