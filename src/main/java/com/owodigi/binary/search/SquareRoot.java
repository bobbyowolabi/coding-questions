package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Square Root Estimation
 * LEVEL: Easy 🟩 | Medium 🟨 | Hard 🟥
 * PROBLEM STATEMENT: Given an integer, find its square root without using the built-in square root function. Only
 * return the integer part (truncate the decimals).
 * SAMPLE DATA:
    Input: 16
    Output: 4

    Input: 8
    Output: 2
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Binary Search
 * RUNTIME COMPLEXITY: O(logn)
 * SPACE COMPLEXITY: O(1)
 */
public class SquareRoot {

    public static int squareRoot(final int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int low = 1, high = n / 2, candidate = -1;
        while (low <= high) {
            final int mid = low + (high - low) / 2;
            final long candidateSquared = (long) mid * mid;  // Prevent integer overflow
            if (candidateSquared == n) {
                return mid;
            } else if (candidateSquared < n) {
                candidate = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return candidate;
    }

    @Test
    public void testCase1() {
        final int input = 4;
        final int expected = 2;
        final int actual = squareRoot(input);
        Assertions.assertEquals(expected, actual, "The square root of " + input + " (Decimals Truncated)");
    }

    @Test
    public void testCase2() {
        final int input = 8;
        final int expected = 2;
        final int actual = squareRoot(input);
        Assertions.assertEquals(expected, actual, "The square root of " + input + " (Decimals Truncated)");
    }

    @Test
    public void testCase3() {
        final int input = 10;
        final int expected = 3;
        final int actual = squareRoot(input);
        Assertions.assertEquals(expected, actual, "The square root of " + input + " (Decimals Truncated)");
    }

    @Test
    public void testCase4() {
        final int input = 1;
        final int expected = 1;
        final int actual = squareRoot(input);
        Assertions.assertEquals(expected, actual, "The square root of " + input + " (Decimals Truncated)");
    }

    @Test
    public void testCase5() {
        final int input = 0;
        final int expected = 0;
        final int actual = squareRoot(input);
        Assertions.assertEquals(expected, actual, "The square root of " + input + " (Decimals Truncated)");
    }
}
