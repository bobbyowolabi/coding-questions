package com.owodigi.depth.first.search;

import com.owodigi.util.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TITLE: Binary Tree Root Path Target Sum
 * LEVEL: Medium
 * STATUS: NOT SOLVED ❌
 * PROBLEM STATEMENT: Given the root of a binary tree an integer targetSum return all of the paths, starting at the
 * root, whose sum equals the target sum.
 * SAMPLE DATA:
 *               1
 *       ┌───────┴───────┐
 *       2               9
 *   ┌───┴───┐       ┌───┴───┐
 *   3       4       10      11
 * ┌─┴─┐   ┌─┴─┐   ┌─┴─┐   ┌─┴─┐
 * 5   6   7   8   12  13  14  15
 */
class RootPathSums {
    private boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void pathSum(final int sum, final int targetSum, final List<Integer> path, final List<List<Integer>> result, final TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (isLeaf(node)) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        pathSum(sum + node.val, targetSum, path, result, node.left);
        pathSum(sum + node.val, targetSum, path, result, node.right);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> result = new ArrayList<>();
        pathSum(0, targetSum, new ArrayList<>(), result, root);
        return result;
    }

    /**
     * Input:
     *               5
     *       ┌───────┴───────┐
     *       4               8
     *   ┌───┴           ┌───┴───┐
     *  11              13       4
     * ┌─┴─┐                   ┌─┴─┐
     * 7   2                   5   1
     */
    @Test
    public void testCase1() {
        final TreeNode input = new TreeNode(5);
        input.left = new TreeNode(4);
        input.left.left = new TreeNode(11);
        input.left.left.left = new TreeNode(7);
        input.left.left.right = new TreeNode(2);
        input.right = new TreeNode(8);
        input.right.left = new TreeNode(13);
        input.right.right = new TreeNode(4);
        input.right.right.left = new TreeNode(5);
        input.right.right.right = new TreeNode(1);
        final List<List<Integer>> expected = Arrays.asList(Arrays.asList(5,4,11,2), Arrays.asList(5,8,4,5));
        final List<List<Integer>> actual = new RootPathSums().pathSum(input, 22);
        Assertions.assertEquals(expected, actual, "root path sum");
    }
}
