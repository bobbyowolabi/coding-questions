package com.owodigi.hash.table;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Two Sum
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * SAMPLE DATA:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            final int secondNumber = target - nums[i];
            if (lookup.containsKey(secondNumber)) {
                return new int[]{i, lookup.get(secondNumber)};
            } else {
                lookup.put(nums[i], i);
            }
        }
        return new int[0];
    }


    private void test(final int[] input, final int target, final int[] expected) {
        final int[] actual = twoSum(input, target);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual, "Indicies of elements");
    }

    @Test
    public void testCase1() {
        final int[] input = {2,7,11,15};
        final int target = 9;
        final int[] expected = {0,1};
        test(input, target, expected);
    }

    @Test
    public void testCase2() {
        final int[] input = {3,2,4};
        final int target = 6;
        final int[] expected = {1,2};
        test(input, target, expected);
    }

    @Test
    public void testCase3   () {
        final int[] input = {3,3};
        final int target = 6;
        final int[] expected = {0,1};
        test(input, target, expected);
    }
}
