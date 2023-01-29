package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
class PathWithGivenSequence {

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static boolean findPath(final int[] sequence, final int index, final TreeNode node) {
        if (node == null || index >= sequence.length) {
            return false;
        }
        if (sequence[index] == node.val) {
            if (isLeaf(node)) {
                return true;
            }
            return findPath(sequence, index + 1, node.left) || findPath(sequence, index + 1, node.right);
        } else {
            return false;
        }
    }

    public static boolean findPath(final TreeNode root, final int[] sequence) {
        return findPath(sequence, 0, root);
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
