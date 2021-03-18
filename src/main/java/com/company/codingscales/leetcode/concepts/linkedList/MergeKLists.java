package com.company.codingscales.leetcode.concepts.linkedList;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return dc(lists, 0, lists.length - 1);
    }

    // bounds inclusive
    ListNode dc(ListNode[] lists, int i, int j) {
        if (i > j)
            return null;
        if (i == j)
            return lists[i];

        int mid = i + (j - i) / 2;

        ListNode left = dc(lists, i, mid);
        ListNode right = dc(lists, mid + 1, j);

        return merge(left, right);
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1; ListNode p2 = head2;
        ListNode dummy = new ListNode();
        ListNode auxHead = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dummy.next = p1;
                p1 = p1.next;
            } else {
                dummy.next = p2;
                p2 = p2.next;
            }

            dummy = dummy.next;
        }

        while (p1 != null) {
            dummy.next = p1;
            dummy = dummy.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            dummy.next = p2;
            dummy = dummy.next;
            p2 = p2.next;
        }

        return auxHead.next;
    }
}
