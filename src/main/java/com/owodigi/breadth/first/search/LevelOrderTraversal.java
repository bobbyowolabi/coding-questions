package com.owodigi.breadth.first.search;

import java.util.*;


/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of
 * all nodes of each level from left to right in separate sub-arrays.
 */
class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final Queue<TreeNode> toVisit = new ArrayDeque<>();
        toVisit.add(root);
        while (toVisit.isEmpty() == false) {
            final int size = toVisit.size();
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
            result.add(level);
            toVisit.clear();
            toVisit.addAll(nextLevel);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
