package com.owodigi.binary.tree.array;

import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL: Easy 🟩 | Medium 🟨 | Hard 🟥
 * PROBLEM STATEMENT:
 * SAMPLE DATA:
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class LargerSubTree {

    private static int left(final int index) {
        return (2 * index) + 1;
    }

    private static int right(final int index) {
        return (2 * index) + 2;
    }

    private static long sum(final int index, final long[] arr) {
        if (index >= arr.length || arr[index] == -1) {
            return 0;
        }
        return arr[index] + sum(left(index), arr) + sum(right(index), arr);
    }

    public static String solution(long[] arr) {
        if (arr == null || arr.length < 2) {
            return "";
        }
        final long leftSum = sum(1, arr);
        final long rightSum = sum(2, arr);
        if (leftSum > rightSum) {
            return "Left";
        } else if (rightSum > leftSum) {
            return "Right";
        } else {
            return "";
        }
    }

    /**
     * Visual:
     *        1
     *      /  \
     *     2     3
     *    / \   /
     *   4   5 6
     *
     * Array:
     * [1, 2, 3, 4, 5, 6]
     */
    @Test
    public void testCase1() {
    }
}
