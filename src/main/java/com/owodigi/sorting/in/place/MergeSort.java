package com.owodigi.sorting.in.place;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * TITLE: Merge Sort
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Write a function mergeSort that takes an integer array as input and sorts the
 * elements of the array in non-descending order using the Merge Sort algorithm.
 * Your function should have the following signature:
 *      public static void mergeSort(int[] arr)
 * Your function should sort the input array in-place (i.e., without using additional memory other than what is
 * required to store the input array).
 * SAMPLE DATA:
 * Input = {4, 2, 6, 1, 9, 8}
 * Output = {1, 2, 4, 6, 8, 9}
 * -------------------
 * STATUS: SOLVED ✅ | NOT SOLVED ❌ | PARTIALLY SOLVED ☑️
 * RUNTIME COMPLEXITY: TBD
 * SPACE COMPLEXITY: TBD
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        throw new UnsupportedOperationException("Implement Me!");
    }

    private void test (final int[] input, final int[] expected) {
        final int[] actual = Arrays.copyOf(input, input.length);
        mergeSort(actual);
        Assertions.assertArrayEquals(expected, actual, "Sorted Array for " + input +
                "; expected: " + Arrays.toString(expected) + "; actual: " + Arrays.toString(actual));
    }

    @Test
    public void testCase1() {
        final int[] input = {4, 2, 6, 1, 9, 8};
        final int[] expected = {1, 2, 4, 6, 8, 9};
        test(input, expected);
    }

    @Test
    public void testCase2() {
        final int[] input = {1, 2, 3, 4, 5};
        final int[] expected = {1, 2, 3, 4, 5};
        test(input, expected);
    }

    @Test
    public void testCase3() {
        final int[] input = {5, 4, 3, 2, 1};
        final int[] expected = {1, 2, 3, 4, 5};
        test(input, expected);
    }

    @Test
    public void testCase4() {
        final int[] input = {4, 2, 6, 1, 9, 8, 2, 4};
        final int[] expected = {1, 2, 2, 4, 4, 6, 8, 9};
        test(input, expected);
    }

    @Test
    public void testCase5() {
        final int[] input = {};
        final int[] expected = {};
        test(input, expected);
    }

    @Test
    public void testCase6() {
        final int[] input = {5};
        final int[] expected = {5};
        test(input, expected);
    }
}
