package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;

/**
 * Title: Path with Maximum Sum (hard)
 * Status: NOT SOLVED
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/B89q6NpX0Vx
 * Problem: Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum. *
 * A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root. The path must contain at least one node.
 */
class MaximumPathSum {
    private static int maxPathSum;

    private static int findMaximumPathSumHelper(final TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeftSum = findMaximumPathSumHelper(node.left);
        int maxRightSum = findMaximumPathSumHelper(node.right);
        maxLeftSum = Math.max(maxLeftSum, 0);
        maxRightSum = Math.max(maxRightSum, 0);
        int currentMax = maxLeftSum + maxRightSum + node.val;
        maxPathSum = Math.max(maxPathSum, currentMax);
        return Math.max(maxLeftSum, maxRightSum) + node.val;
    }

    public static int findMaximumPathSum(final TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        findMaximumPathSumHelper(root);
        return maxPathSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
