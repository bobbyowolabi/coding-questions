package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Subarray Sum - Fixed
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Given an array (list) nums consisted of only non-negative integers, find the largest sum among
 * all subarrays of length k in nums.
 * SAMPLE DATA:
 * nums = [1, 2, 3, 7, 4, 1], k = 3
 * output = 14 (largest length 3 subarray sum is given by [3, 7, 4])
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Sliding Window
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public abstract class MaxSumFixedSubArray {

    public abstract int subarraySumFixed(List<Integer> nums, int k);

    private void test(final List<Integer> input, final int k, final int expected) {
        final int actual = subarraySumFixed(input, k);
        Assertions.assertEquals(expected, actual, "Largest sum of size %d subarray".formatted(k));
    }

    @Test
    public void testCase1() {
        test(List.of(1, 2, 3, 7, 4, 1), 3, 14);
    }

    @Test
    public void testCase2() {
        test(List.of(2, 1, 5, 1, 3, 2), 3, 9);
    }

    @Test
    public void testCase3() {
        test(List.of(2, 3, 4, 1, 5), 2, 7);
    }
}
