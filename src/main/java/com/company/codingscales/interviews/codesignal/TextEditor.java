package com.company.codingscales.interviews.codesignal;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

class Text {
    private String timestamp;
    private String value;
    private Stack<String> valueHistory;

    public Text(String timestamp, String value) {
        valueHistory = new Stack();
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Stack<String> getHistory() {
        return valueHistory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        valueHistory.push(this.value);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Timestamp: " + timestamp + ", value: " + value;
    }
}

class MyTextComparator implements Comparator<Text> {
    private int compareTimestampString(Text t1, Text t2) {
        int nonZeroIndex = 0;

        String s1 = t1.getTimestamp();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '0') {
                continue;
            }

            nonZeroIndex = i;
            break;
        }

        s1 = s1.substring(nonZeroIndex);

        String s2 = t2.getTimestamp();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '0') {
                continue;
            }

            nonZeroIndex = i;
            break;
        }

        s2 = s2.substring(nonZeroIndex);

        if (s1.length() > s2.length()) {
            return 1;
        } else if (s1.length() < s2.length()) {
            return -1;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (Character.getNumericValue(s1.charAt(i)) > Character.getNumericValue(s2.charAt(i))) {
                    return 1;
                } else if (Character.getNumericValue(s1.charAt(i)) < Character.getNumericValue(s2.charAt(i))) {
                    return -1;
                }
            }
        }

        return 1;
    }

    @Override
    public int compare(Text o1, Text o2) {
        return compareTimestampString(o1, o2);
    }
}

class TextEditor {
    public String textEditor(String[][] input) {
        Stack<Text> stack = new Stack();
        Stack<Text> redoStack = new Stack();
        String selectedChars = "";
        String prevOperation = null;

        for (String[] inputStr : input) {
            String timestamp = inputStr[0];
            String operation = inputStr[1];
            prevOperation = operation;

            switch (operation) {
                case "APPEND":
                    String value = inputStr[2];
                    if (stack.isEmpty() || !prevOperation.equals("SELECT")) {
                        Text currText = new Text(timestamp, value);
                        stack.push(currText);
                    } else if (prevOperation.equals("SELECT")) {
                        Text prev = stack.pop();
                        String prevValue = prev.getValue();
                        prev.setValue(prevValue.replace(selectedChars, value));
                        stack.push(prev);
                    }

                    break;

                case "BACKSPACE":
                    Text prev = !stack.isEmpty() ? stack.pop() : null;
                    if (prev != null) {
                        String prevValue = prev.getValue();
                        if (prevOperation.equals("SELECT")) {
                            prev.setValue(prevValue.replace(selectedChars, ""));
                        } else {
                            prev.setValue(prevValue.substring(0, prevValue.length() - 1));
                        }
                        stack.push(prev);
                    }
                    break;

                case "UNDO":
                    if (!stack.isEmpty()) {
                        redoStack.push(stack.pop());
                    }
                    break;

                case "REDO":
                    if (!redoStack.isEmpty()) {
                        stack.push(redoStack.pop());
                    }
                    break;

                case "SELECT":
                    int startIndex = Integer.parseInt(inputStr[2]);
                    int endIndex = Integer.parseInt(inputStr[3]);
                    Text prevText = !stack.isEmpty() ? stack.pop() : null;
                    if (prevText != null) {
                        String prevValue = prevText.getValue();

                        if (startIndex >= prevValue.length()) {
                            break;
                        }

                        selectedChars = prevValue.substring(startIndex, Math.max(endIndex, prevValue.length()));
                    }
                    break;

                case "BOLD":
                    if (stack.isEmpty()) {
                        break;
                    }
                    Text previousText = stack.pop();
                    String prevValue = previousText.getValue();

                    prevValue = previousText.getValue();
                    previousText.setValue(prevValue.replace(selectedChars, "*" + selectedChars + "*"));
                    stack.push(previousText);

                    break;

                default:
                    break;
            }
        }

        if (stack.isEmpty())
            return "";

        PriorityQueue<Text> pq = new PriorityQueue<>(new MyTextComparator());
        while (!stack.isEmpty()) {
            pq.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().getValue());
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


