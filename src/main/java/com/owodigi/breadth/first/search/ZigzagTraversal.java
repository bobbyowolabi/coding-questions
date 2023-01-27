package com.owodigi.breadth.first.search;

import java.util.*;

/**
 * Title: Zigzag Traversal (medium)
 * Status: SOLVED
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0
 * Problem Statement: Given a binary tree, populate an array to represent its zigzag level order traversal. You should
 * populate the values of all nodes of the first level from left to right, then right to left for the next level and
 * keep alternating in the same manner for the following levels.
 */
enum Order {LEFT_TO_RIGHT, RIGHT_TO_LEFT};

class ZigzagTraversal {

    private static void addIfNotNull(final TreeNode node, final List<TreeNode> list) {
        if (node != null) {
            list.add(node);
        }
    }

    public static List<List<Integer>> traverse(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final Queue<TreeNode> visited = new ArrayDeque<>();
        visited.add(root);
        Order order = Order.LEFT_TO_RIGHT;
        while(visited.isEmpty() == false) {
            final List<Integer> level = new ArrayList<>();
            final List<TreeNode> nextLevel = new ArrayList<>();
            for (final TreeNode node : visited) {
                if (order == Order.LEFT_TO_RIGHT) {
                    level.add(node.val);
                } else {
                    if (level.isEmpty()) {
                        level.add(node.val);
                    } else {
                        level.add(level.size() - 1, node.val);
                    }
                }
                addIfNotNull(node.left, nextLevel);
                addIfNotNull(node.right, nextLevel);
            }
            result.add(level);
            visited.clear();
            visited.addAll(nextLevel);
            order = order == Order.LEFT_TO_RIGHT ? Order.RIGHT_TO_LEFT : Order.LEFT_TO_RIGHT;
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
