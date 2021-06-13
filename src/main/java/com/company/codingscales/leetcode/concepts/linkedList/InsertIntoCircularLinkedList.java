package com.company.codingscales.leetcode.concepts.linkedList;

public class InsertIntoCircularLinkedList {
    static class Node {
        Node next;
        int val;
        Node() {}
        Node(int val) {}
        Node(int val, Node next) {}
    }

    public Node insert(Node head, int insertVal) {
        // need to find where curr.val < insertVal < curr.next.val
        if (head == null) {
            Node n = new Node(insertVal);
            n.next = n;
            return n;
        }

        Node prev = head;
        Node curr = head.next;

        boolean shouldInsert = false;
        do {

            if (prev.val <= insertVal && insertVal <= curr.val) {
                // ideal case 3 -> 5 (insert 4) => 3 -> 4 -> 5
                shouldInsert = true;
            } else if (prev.val > curr.val && (insertVal >= prev.val || insertVal <= curr.val)) {

                shouldInsert = true;
                // 5 -> 3 (insert 2) => 5 -> 2 -> 3
                // 5 -> 3 (insert 6) => 5 -> 6 -> 3
                // when should u not insert ?

                // 3, 4, 1 => (insert 2) => 4 - 1 (2 is not greater than 4 and also 2 is not smaller than 1)
            }

            if (shouldInsert) {
                Node n = new Node(insertVal, prev.next);
                prev.next = n;

                return head;
            }

            prev = prev.next;
            curr = curr.next;

        } while (prev != head);

        // 1 -> 1 (self) => and need to insert 2 => 1 -> 2
        head.next = new Node(insertVal, curr);
        return head;
    }
}
