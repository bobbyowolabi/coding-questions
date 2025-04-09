package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Find the length of the longest subarray with sum smaller than or equal to a target
 * SAMPLE DATA:
 * Given input nums = [1, 6, 3, 1, 2, 4, 5] and target = 10, then the longest subarray that does not exceed 10 is [3, 1, 2, 4], so the output is 4 (length of [3, 1, 2, 4]).
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Sliding Window
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class SubArraySumLongest {

    public static int subarraySumLongest(List<Integer> nums, int target) {
        int left = 0, right = 0, sum = 0, maxLength = 0;
        while (right < nums.size()) {
            sum += nums.get(right);
            if (sum <= target) {
                final int currentLength = right - left + 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                sum -= nums.get(left++);
            }
            ++right;
        }
        return maxLength;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(1, 6, 3, 1, 2, 4, 5);
        final int target = 10;
        final int expected = 4;
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual, "Length of the longest subarray with sum smaller than or equal to a target");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(5, 1, 2, 3, 4);
        final int target = 7;
        final int expected = 3; // [1,2,3]
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(10, 20, 30);
        final int target = 5;
        final int expected = 0; // No subarray sums ≤ 5
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(2, 2, 2, 2, 2);
        final int target = 6;
        final int expected = 3; // [2,2,2]
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase5() {
        final List<Integer> input = List.of(1, 2, 3, 4, 5);
        final int target = 15;
        final int expected = 5; // whole array
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase6() {
        final List<Integer> input = List.of(7, 3, 1, 2, 1, 1, 5);
        final int target = 8;
        final int expected = 5;
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase7() {
        final List<Integer> input = List.of();
        final int target = 10;
        final int expected = 0; // empty array
        final int actual = subarraySumLongest(input, target);
        Assertions.assertEquals(expected, actual);
    }
}
