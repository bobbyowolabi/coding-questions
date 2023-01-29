package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;

import java.util.*;

/**
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of
 * each path equals ‘S’.
 */
class FindAllTreePaths {

    private static void findPaths(final int target, int sum, final TreeNode root, final List<Integer> visited, final List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }
        visited.add(root.val);
        sum += root.val;
        if (sum == target) {
            allPaths.add(new ArrayList<Integer>(visited));
        } else if (sum < target) {
            findPaths(target, sum, root.left, visited, allPaths);
            findPaths(target, sum, root.right, visited, allPaths);
        }
        visited.remove(visited.size() - 1);
    }

    public static List<List<Integer>> findPaths(final TreeNode root, int sum) {
        final List<List<Integer>> allPaths = new ArrayList<>();
        findPaths(sum, 0, root, new ArrayList<>(), allPaths);
        return allPaths;
    }

    public static void main(String[] args) {
        /**
         * S: 23
         * Output: [[12, 7, 4], [12, 1, 10]]
         * Explanation: Here are the two paths with sum '23':12 -> 7 -> 4 and 12 -> 1 -> 10
         */
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
