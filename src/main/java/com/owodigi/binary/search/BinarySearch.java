package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Binary Search
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: You are given a sorted array of integers nums and an integer target. Your task is to write a
 * function to search for the target value in the array using the binary search algorithm
 * If the target exists, return its index. Otherwise, return -1.
 * SAMPLE DATA:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 is located at index 4.
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 is not in the array.
 * -------------------
 * STATUS: SOLVED ✅
 * RUNTIME COMPLEXITY: O(log n)
 * SPACE COMPLEXITY: O(1)
 */
public class BinarySearch {

    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            final int midIndex = (left + right) / 2;
            final int mid = arr.get(midIndex);
            if (target == mid) {
                return midIndex;
            } else if (target < mid) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        return -1;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(1, 3, 5, 7, 8);
        final int target = 5;
        final int expected = 2;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);
        final int target = 0;
        final int expected = -1;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(2, 8, 89, 120, 1000);
        final int target = 120;
        final int expected = 3;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(10, 20);
        final int target = 20;
        final int expected = 1;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase5() {
        final List<Integer> input = List.of(1);
        final int target = 1;
        final int expected = 0;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase6() {
        final List<Integer> input = List.of();
        final int target = 1;
        final int expected = -1;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }

    @Test
    public void testCase7() {
        final List<Integer> input = List.of(1, 2, 3, 4, 5);
        final int target = 10;
        final int expected = -1;
        final int actual = binarySearch(input, target);
        Assertions.assertEquals(expected, actual, "Target Index");
    }
}
