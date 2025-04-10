package com.owodigi.sliding.window;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Shortest SubArray Sum
 * LEVEL: Easy 🟩 | Medium 🟨
 * PROBLEM STATEMENT: find the length of the shortest subarray such that the subarray sum is at least target.
 * SAMPLE DATA:
 * nums = [1, 4, 1, 7, 3, 0, 2, 5] and target = 10
 * then the smallest window with the sum >= 10 is [7, 3] with length 2. So the output is 2.
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * PATTERN: Binary Search | ...
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class ShortestSubArraySum {

    public static int subarraySumShortest(List<Integer> nums, int target) {
        int left = 0, min = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < nums.size(); ++right) {
            sum += nums.get(right);
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums.get(left++);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(1, 4, 1, 7, 3, 0, 2, 5);
        final int target = 10;
        final int expected = 2;
        final int actual = subarraySumShortest(input, target);
        Assertions.assertEquals(expected, actual, "length of the shortest subarray with sum >= target");
    }
}
