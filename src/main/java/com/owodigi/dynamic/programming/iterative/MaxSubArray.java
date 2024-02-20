package com.owodigi.dynamic.programming.iterative;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Maximum Subarray
 * LEVEL: Medium
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * SAMPLE DATA:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaxSubArray {

    public int maxSubArray(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentSum = nums[0], max = nums[0] ;
        for (int i = 1; i < nums.length; ++i) {
            final int num = nums[i];
            currentSum = Math.max(num, num + currentSum);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    private void test(final int[] input, final int expected) {
        final int actual = maxSubArray(input);
        Assertions.assertEquals(expected, actual, "Maximum sub array value");
    }

    @Test
    public void testCase1() {
        final int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        final int expected = 6;
        test(input, expected);
    }

    @Test
    public void testCase2() {
        final int[] input = {1};
        final int expected = 1;
        test(input, expected);
    }

    @Test
    public void testCase3() {
        final int[] input = {5,4,-1,7,8};
        final int expected = 23;
        test(input, expected);
    }

    @Test
    public void testCase4() {
        final int[] input = {-1};
        final int expected = -1;
        test(input, expected);
    }

    @Test
    public void testCase5() {
        final int[] input = {-5,-4,-1,-7,-8};
        final int expected = -1;
        test(input, expected);
    }

    @Test
    public void testCase6() {
        final int[] input = {5,4,1,7,8};
        final int expected = 25;
        test(input, expected);
    }

    @Test
    public void testCase7() {
        final int[] input = {0};
        final int expected = 0;
        test(input, expected);
    }

    @Test
    public void testCase8() {
        final int[] input = {1000};
        final int expected = 1000;
        test(input, expected);
    }
}
