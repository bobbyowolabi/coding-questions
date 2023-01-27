package com.owodigi.breadth.first.search;

import java.util.*;

/**
 * Title: Reverse Level Order Traversal (easy)
 * Status: SOLVED
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/m2N6GwARL8r
 * Problem Statement: Given a binary tree, populate an array to represent its level-by-level traversal in reverse
 * order, i.e., the lowest level comes first. You should populate the values of all nodes in each level from left to
 * right in separate sub-arrays.
 */
class ReverseLevelOrderTraversal {

    public static List<List<Integer>> traverse(final TreeNode root) {
        final List<List<Integer>> result = new LinkedList<List<Integer>>();
        final Queue<TreeNode> toVisit = new ArrayDeque<>();
        toVisit.add(root);
        while (toVisit.isEmpty() == false) {
            final List<Integer> level = new ArrayList<>();
            final List<TreeNode> nextLevel = new ArrayList<>();
            for (final TreeNode node : toVisit) {
                level.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            toVisit.clear();
            toVisit.addAll(nextLevel);
            result.add(0, level);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
