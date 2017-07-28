package com.epam;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Set<Node> nodes = new HashSet<>();
        Node node = head;
        while (node != null) {
            if (nodes.contains(node)) return true;
            nodes.add(node);
            node = node.next;
        }
        return false;
    }
}
