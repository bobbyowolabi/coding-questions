package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Minimum in Rotated Sorted Array
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: A sorted array of unique integers was rotated at an unknown pivot. Find the index of the minimum
 * element in this array.
 * SAMPLE DATA:
 * Input: [30, 40, 50, 10, 20]
 *
 * Output: 3
 *
 * Explanation: The smallest element is 10, and its index is 3.
 *
 * Input: [3, 5, 7, 11, 13, 17, 19, 2]
 *
 * Output: 7
 *
 * Explanation: The smallest element is 2, and its index is 7.
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Binary Search
 * RUNTIME COMPLEXITY: O(logn)
 * SPACE COMPLEXITY: O(1)
 */
public class MinimumInRotatedSortedArray {

    public static int findMinRotated(final List<Integer> arr) {
        int leftIndex = 0, rightIndex = arr.size() - 1, candidate = -1;
        while (leftIndex <= rightIndex) {
            final int midIndex = (rightIndex + leftIndex) / 2;
            final int mid = arr.get(midIndex);
            final int right = arr.get(rightIndex);
            if (mid > right) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return leftIndex;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(30, 40, 50, 10, 20);
        final int expected = 3;
        final int actual = findMinRotated(input);
        Assertions.assertEquals(expected, actual, "The index of the minimum element in this array");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(0, 1, 2, 3, 4, 5);
        final int expected = 0;
        final int actual = findMinRotated(input);
        Assertions.assertEquals(expected, actual, "The index of the minimum element in this array");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(0);
        final int expected = 0;
        final int actual = findMinRotated(input);
        Assertions.assertEquals(expected, actual, "The index of the minimum element in this array");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(1, 2, 3, 5, 8, 0);
        final int expected = 5;
        final int actual = findMinRotated(input);
        Assertions.assertEquals(expected, actual, "The index of the minimum element in this array");
    }
}
