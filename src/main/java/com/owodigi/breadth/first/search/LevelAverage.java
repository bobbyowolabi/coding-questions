package com.owodigi.breadth.first.search;

import java.util.*;

/**
 * Title: Level Averages in a Binary Tree (easy)
 * Status: SOLVED ✅
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/YQWkA2l67GW
 * Problem Statement: Given a binary tree, populate an array to represent the averages of all of its levels.
 */
class LevelAverage {
    public static List<Double> findLevelAverages(final TreeNode root) {
        final List<Double> result = new ArrayList<>();
        final Queue<TreeNode> toVisit = new ArrayDeque<>();
        toVisit.add(root);
        while (toVisit.isEmpty() == false) {
            final int levelSize = toVisit.size();
            double sum = 0;
            for (int i = 0; i < levelSize; ++i) {
                final TreeNode node = toVisit.poll();
                sum += node.val;
                if (node.left != null) {
                    toVisit.add(node.left);
                }
                if (node.right != null) {
                    toVisit.add(node.right);
                }
            }
            final double average = sum / levelSize;
            result.add(average);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}

