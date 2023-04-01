package com.owodigi.two.pointers;

import java.util.*;

import com.owodigi.util.Assert;
import com.owodigi.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL:
 * STATUS: SOLVED ✅ | NOT SOLVED ❌
 * PROBLEM STATEMENT: Parse an array binary tree representation and return the corresponding binary tree object.
 * SAMPLE DATA:
 */
public class ParseBinaryTreeArray {

    private void set(final Node root, final Integer left, final Integer right) {
        root.left = left == null ? null : new Node(left);
        root.right = right == null ? null : new Node(right);
    }

    public void parse(final int rootPosition, final Node root, final int childrenPosition, final Integer[] tree) {
//        if (childrenPosition >= tree.length) {
//            return;
//        }
//        set(root, tree[childrenPosition], tree[childrenPosition + 1]);
//        parse(root.left, tree[pos + 3], tree[pos + 4], pos + 1, tree);
//        parse(root.right, tree[pos + 3], tree[pos + 4], pos + 1, tree);
    }

    public Node parse(final Integer[] tree) {
        if (tree == null || tree.length == 0) {
            return null;
        }
        final Node root = new Node(tree[0]);
//        parse(root, );
        return root;
    }

    @Test
    public void testCase1() {
        final Integer[] input = {6,2,8,0,4,7,9,null,null,3,5};
        final Node expected = new Node(6);
        expected.left = new Node(2);
        expected.left.left = new Node(0);
        expected.left.right = new Node(4);
        expected.left.right.left = new Node(3);
        expected.left.right.right = new Node(5);
        expected.right = new Node(8);
        expected.right.left = new Node(7);
        expected.right.right = new Node(9);
        final Node actual = parse(input);
        Assert.assertEquals(expected, actual);
    }
}
