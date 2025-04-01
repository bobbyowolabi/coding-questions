package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Find Element in Sorted Array with Duplicates
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: Given a sorted array of integers and a target integer, find the first occurrence of the target and return its index. Return -1 if the target is not in the array.
 * SAMPLE DATA:
 * Input:
 *
 * arr = [1, 3, 3, 3, 3, 6, 10, 10, 10, 100]
 * target = 3
 * Output: 1
 *
 * Explanation: The first occurrence of 3 is at index 1.
 *
 * Input:
 *
 * arr = [2, 3, 5, 7, 11, 13, 17, 19]
 * target = 6
 * Output: -1
 *
 * Explanation: 6 does not exist in the array.
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Binary Search
 * RUNTIME COMPLEXITY: O(logn)
 * SPACE COMPLEXITY: O(1)
 */
public class FirstOccurrence {

    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int left = 0, right = arr.size () - 1, result = -1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            final int candidate = arr.get(mid);
            if (candidate >= target) {
                if (candidate == target) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        final int target = 3;
        final int expected = 1;
        final int actual = findFirstOccurrence(input, target);
        Assertions.assertEquals(expected, actual, "Index of the first occurrence of the target");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        final int target = 100;
        final int expected = 9;
        final int actual = findFirstOccurrence(input, target);
        Assertions.assertEquals(expected, actual, "Index of the first occurrence of the target");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        final int target = 5;
        final int expected = -1;
        final int actual = findFirstOccurrence(input, target);
        Assertions.assertEquals(expected, actual, "Index of the first occurrence of the target");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        final int target = 1;
        final int expected = 0;
        final int actual = findFirstOccurrence(input, target);
        Assertions.assertEquals(expected, actual, "Index of the first occurrence of the target");
    }

    @Test
    public void testCase5() {
        final List<Integer> input = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        final int target = 3;
        final int expected = 1;
        final int actual = findFirstOccurrence(input, target);
        Assertions.assertEquals(expected, actual, "Index of the first occurrence of the target");
    }
}
