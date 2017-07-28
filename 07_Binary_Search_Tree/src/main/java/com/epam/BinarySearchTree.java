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

    boolean checkHelper(Node node, HashSet<Integer> set) {

        if (node == null){
            return true;
        }
        if (set.contains(node.data)){
            return false;
        }

        set.add(node.data);
        if (node.left != null && (node.data >= node.right.data)){
            return false;
        }
        if (node.right != null && (node.data <= node.left.data)){
            return false;
        }
        return (checkHelper(node.left, set) && checkHelper(node.right, set));
    }
}
