package com.owodigi.breadth.first.search;

import java.util.*;

/**
 * Title: Minimum Depth of a Binary Tree (easy)
 * Status: SOLVED ✅
 * Source: https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO
 * Problem Statement: Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the
 * shortest path from the root node to the nearest leaf node.
 */
class MinimumBinaryTreeDepth {
    public static int findDepth(final TreeNode root) {
        final Queue<TreeNode> toVisit =  new ArrayDeque<>();
        toVisit.add(root);
        int depth = 0;
        while (toVisit.isEmpty() == false) {
            final int levelSize = toVisit.size();
            ++depth;
            for (int i = 0; i < levelSize; ++i) {
                final TreeNode node = toVisit.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    toVisit.add(node.left);
                }
                if (node.right != null) {
                    toVisit.add(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}

