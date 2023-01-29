package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class SumOfPathNumbers {

    private static int toInt(final List<Integer> number) {
        int sum = 0;
        for (int i = 0; i < number.size(); ++i) {
            final int digit = number.get(i);
            final int exponent = number.size() - i - 1;
            sum += digit * Math.pow(10, exponent);
        }
        return sum;
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static int findSumOfPathNumbers(final List<Integer> number, final TreeNode node) {
        if (node == null) {
            return 0;
        }
        number.add(node.val);
        if (isLeaf(node)) {
            int sum = toInt(number);
            number.remove(number.size() - 1);
            return sum;
        }
        int sum = findSumOfPathNumbers(number, node.left);
        sum += findSumOfPathNumbers(number, node.right);
        number.remove(number.size() - 1);
        return sum;
    }

    public static int findSumOfPathNumbers(final TreeNode root) {
        return findSumOfPathNumbers(new ArrayList<>(), root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));

        root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));

    }
}
