package com.owodigi.com.owodigi.depth.first.search;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class TreePathSum {

    private static boolean hasPath(final int target, int sum, final TreeNode node) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (sum == target) {
            return true;
        } else if (sum < target) {
            return hasPath(target, sum, node.left) || hasPath(target, sum, node.right);
        } else {
            return false;
        }
    }

    public static boolean hasPath(final TreeNode root, final int sum) {
        return hasPath(sum, 0, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}
