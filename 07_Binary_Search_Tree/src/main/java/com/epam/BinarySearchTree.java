package com.epam;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {


    public boolean checkBST(Node root) {
        if (root == null){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return checkHelper(root, new HashSet<Integer>());
    }

    int maxInSubtree(Node node){
        while (node.right != null){
            node = node.right;
        }
        return node.data;
    }

    int minInSubtree(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node.data;
    }

    boolean checkHelper(Node node, HashSet<Integer> set) {

        if (node == null){
            return true;
        }
        if (set.contains(node.data)){
            return false;
        }

        set.add(node.data);
        if (node.left != null && (node.data <= maxInSubtree(node.left))){
            return false;
        }
        if (node.right != null && (node.data >= minInSubtree(node.right))){
            return false;
        }
        return (checkHelper(node.left, set) && checkHelper(node.right, set));
    }
}
