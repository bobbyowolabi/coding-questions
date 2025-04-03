package com.owodigi.two.pointers;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Two Sum Sorted
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: Given an array of integers sorted in ascending order, find two numbers that add up to a given
 * target. Return the indices of the two numbers in ascending order. You can assume elements in the array are unique
 * and there is only one solution. Do this in O(n) time and with constant auxiliary space.
 * SAMPLE DATA:
 *
 * Input:
 *
 * arr: a sorted integer array
 * target: the target sum we want to reach
 * Sample Input: [2, 3, 4, 5, 8, 11, 18], 8
 *
 * Sample Output: 1 3
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Two Pointer
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class TwoSum {

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        while (left != right) {
            final int sum = arr.get(left) + arr.get(right);
            if (sum == target) {
                return List.of(left, right);
            } else if (sum > target) {
                --right;
            } else {
                ++left;
            }
        }
        return List.of();
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(2, 3, 5, 8, 11, 15);
        final int target = 5;
        final List<Integer> expected = List.of(0, 1);
        final List<Integer> actual = twoSumSorted(input, target);
        Assertions.assertEquals(expected, actual, "Indices of the two numbers that add up to the target");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(1, 2, 4, 6, 10);
        final int target = 8;
        final List<Integer> expected = List.of(1, 3); // 2 + 6 = 8
        final List<Integer> actual = twoSumSorted(input, target);
        Assertions.assertEquals(expected, actual, "Indices of the two numbers that add up to the target");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(0, 1, 2, 3, 9);
        final int target = 3;
        final List<Integer> expected = List.of(0, 3); // 0 + 3 = 3
        final List<Integer> actual = twoSumSorted(input, target);
        Assertions.assertEquals(expected, actual, "Indices of the two numbers that add up to the target");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(1, 3, 4, 5, 7, 10);
        final int target = 13;
        final List<Integer> expected = List.of(1, 5);
        final List<Integer> actual = twoSumSorted(input, target);
        Assertions.assertEquals(expected, actual, "Indices of the two numbers that add up to the target");
    }

    @Test
    public void testCase5() {
        final List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        final int target = 11;
        final List<Integer> expected = List.of(4, 5); // 5 + 6 = 11
        final List<Integer> actual = twoSumSorted(input, target);
        Assertions.assertEquals(expected, actual, "Indices of the two numbers that add up to the target");
    }
}
