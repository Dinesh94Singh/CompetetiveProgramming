package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class TextEditor {
    ArrayDeque<Text> history;
    ArrayDeque<Text> redo;

    int start, end;

    static class MyComparator implements Comparator<Text> {
        @Override
        public int compare(final Text curr, final Text other) {
            return Long.compare(Long.parseLong(curr.timeStamp), Long.parseLong(other.timeStamp));
        }
    }

    static class Text implements Comparable<Text> {
        String val;
        String timeStamp;
        String operation;
        Text prev;

        Text() {
        }

        Text(String val, String timeStamp, String operation) {
            this.val = val;
            this.timeStamp = timeStamp;
            this.operation = operation;
        }

        @Override
        public int compareTo(final Text other) {
            return Long.compare(Long.parseLong(timeStamp), Long.parseLong(other.timeStamp));
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Text text = (Text) o;

            if (!Objects.equals(val, text.val)) return false;
            if (!timeStamp.equals(text.timeStamp)) return false;
            return Objects.equals(operation, text.operation);
        }

        @Override
        public int hashCode() {
            int result = val != null ? val.hashCode() : 0;
            result = 31 * result + timeStamp.hashCode();
            result = 31 * result + (operation != null ? operation.hashCode() : 0);
            return result;
        }
    }

    void append(String value, String timeStamp) {
        Text t = new Text(value, timeStamp, "APPEND");
        history.offerLast(t);
    }

    void backSpace(String timeStamp) {
        if (history.isEmpty())
            return;

        Text t = history.peekLast();
        String prevVal = t.val;

        Text curr = new Text();

        if (prevVal.isEmpty())
            return;

        curr.val = prevVal.substring(0, prevVal.length() - 1);
        curr.operation = "BACKSPACE";
        curr.timeStamp = timeStamp;

        history.offerLast(curr);
    }

    void undo(String timeStamp) {
        if (history.isEmpty())
            return;
        Text t = history.pollLast();
        Text curr = new Text(t.val, timeStamp, t.operation);
        redo.offerLast(curr);
    }

    void redo(String timeStamp) {
        if (redo.isEmpty())
            return;
        Text t = redo.pollLast();
        if (history.peekLast().compareTo(t) == -1 || history.peekLast().compareTo(t) == 0) {
            history.offerLast(t);
        }
    }

    /*
        1. APPEND
        2. BACKSPACE
        3. UNDO
        4. REDO
        5. CHRONOLOGICAL ORDER
        6. SELECT
        7. BOLD
     */
    String textEditor(String[][] input) {
        history = new ArrayDeque<>();
        redo = new ArrayDeque<>();

        for(final String[] each : input) {
            String timeStamp = each[0];
            String operation = "", val = "";
            if (each.length > 1) {
                operation = each[1];
            }

            if (each.length > 2) {
                val = each[2];
            }

            switch(operation) {
                case "APPEND": append(val, timeStamp); break;
                case "BACKSPACE": backSpace(timeStamp); break;
                case "UNDO": undo(timeStamp); break;
                case "REDO": redo(timeStamp); break;
               default: break;
            }
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Text> pq = new PriorityQueue<Text>(new MyComparator());
        while (!history.isEmpty()) {
            pq.offer(history.pollLast());
        }

        while(!pq.isEmpty()) {
            Text t = pq.poll();
            sb.append(t.val);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        String[][] input = {{"0", "APPEND", "Hey You"}, {"1", "UNDO"}, {"2", "APPEND", " don't let me down"}, {"3", "REDO"}};
        System.out.println(editor.textEditor(input));

        String[][] input2 = {{"0", "APPEND", "Hey"}, {"1", "APPEND", " there"}, {"3", "UNDO"}, {"4", "REDO"}};
        System.out.println(editor.textEditor(input2));
    }
}
