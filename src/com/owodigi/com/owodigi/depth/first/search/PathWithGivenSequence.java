package com.owodigi.com.owodigi.depth.first.search;

import java.util.*;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
class PathWithGivenSequence {

    // 111 = (10^2)*1   +   (10^1)*1    + (10^0)*1
    //     = 100        +   10          +  1

    private static int toInteger(final List<Integer> number) {
        int value = 0;
        for (int i = 0; i < number.size(); ++i) {
            final int exponent = number.size() - i - 1;
            value += (Math.pow(10, exponent) * number.get(i));
        }
        return value;
    }

    private static int toInteger(final int[] number) {
        int value = 0;
        for (int i = 0; i < number.length; ++i) {
            final int exponent = number.length - i - 1;
            value += (Math.pow(10, exponent) * number[i]);
        }
        return value;
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static boolean findPath(final int target, final List<Integer> path, final TreeNode node) {
        if (node == null) {
            return false;
        }
        path.add(node.val);
        if (isLeaf(node)) {
            final int candidate = toInteger(path);
            if (target == candidate)
                return true;
        }
        final boolean hasPath = findPath(target, path, node.left) || findPath(target, path, node.right);
        path.remove(path.size() - 1);
        return hasPath;
    }

    public static boolean findPath(final TreeNode root, final int[] sequence) {
        final int target = toInteger(sequence);
        return findPath(target, new ArrayList<>(), root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));

        root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 9 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 9, 9 }));
    }
}
