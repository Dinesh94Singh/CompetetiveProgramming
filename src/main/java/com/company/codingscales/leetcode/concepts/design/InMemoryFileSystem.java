package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class InMemoryFileSystem {
    static class Node {
        boolean isFile;
        HashMap<String, Node> nodes;
        String name;
        String content;

        Node(String name, Boolean isFile) {
            this.name = name;
            this.content = "";
            this.isFile = isFile;
            nodes = new HashMap<>();
        }
    }

    Node root;

    public InMemoryFileSystem() {
        root = new Node("/", false);
    }

    public List<String> ls(String path) {
        String[] dirs = path.split("/");

        Node curr = root;

        for(int i = 1; i < dirs.length; i++) {
            String each = dirs[i];
            if (curr.nodes.containsKey(each)) {
                curr = curr.nodes.get(each);
            } else {
                return new ArrayList<>(); // path doesn't exist the file
            }
        }

        if (curr.isFile)
            return Collections.singletonList(curr.name);

        List<String> res = new ArrayList<>();

        for(Node n : curr.nodes.values()) {
            res.add(n.name);
        }

        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        String[] dirs = path.split("/");

        Node curr = root;

        for(int i = 1; i < dirs.length; i++) {
            String each = dirs[i];
            if (curr.nodes.containsKey(each)) {
                curr = curr.nodes.get(each);
            } else {
                curr.nodes.put(each, new Node(each, false));
                curr = curr.nodes.get(each);
            }
        }
    }

    public void addContentToFile(String path, String content) {
        String[] dirs = path.split("/");

        Node curr = root;

        for(int i = 1; i < dirs.length; i++) {
            String each = dirs[i];
            if (curr.nodes.containsKey(each)) {
                curr = curr.nodes.get(each);
            } else {
                curr.nodes.put(each, new Node(each, i == dirs.length - 1));
                curr = curr.nodes.get(each);
            }
        }

        curr.content += content;
    }

    public String readContentFromFile(String path) {
        String[] dirs = path.split("/");

        Node curr = root;

        for(int i = 1; i < dirs.length; i++) {
            String each = dirs[i];
            if (curr.nodes.containsKey(each)) {
                curr = curr.nodes.get(each);
            } else {
                return ""; // path doesn't exist the file
            }
        }

        return curr.isFile ? curr.content : "";
    }

    public static void main(String[] args) {
        InMemoryFileSystem fs = new InMemoryFileSystem();
        fs.ls("/");
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        fs.ls("/");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
    }
}
