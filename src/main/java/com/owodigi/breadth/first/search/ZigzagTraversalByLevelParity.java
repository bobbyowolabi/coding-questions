package com.owodigi.breadth.first.search;

import com.owodigi.util.TreeNode;

import java.util.*;

/**
 * Title: Zigzag Traversal (medium)
 * Status: SOLVED
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0
 * Problem Statement: Given a binary tree, populate an array to represent its zigzag level order traversal. You should
 * populate the values of all nodes of the first level from left to right, then right to left for the next level and
 * keep alternating in the same manner for the following levels.
 */
class ZigzagTraversalByLevelParity {

    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        final List<List<Integer>> result = new ArrayList<>();
        final Queue<Node<Integer>> toVisit = new ArrayDeque<>();
        toVisit.add(root);
        int level = 0;
        while(toVisit.isEmpty() == false) {
            final List<Integer> currentLevel = new ArrayList<>();
            final List<Node<Integer>> nextLevel = new ArrayList<>();
            for (final Node<Integer> node : toVisit) {
                currentLevel.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            toVisit.clear();
            toVisit.addAll(nextLevel);
            if (level % 2 != 0) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            ++level;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
