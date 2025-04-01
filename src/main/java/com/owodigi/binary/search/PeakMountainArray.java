package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: The Peak of a Mountain Array
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: A mountain array is defined as an array that
 *
 * has at least 3 elements
 * has an element with the largest value called "peak", with index k. The array elements strictly increase from the
 * first element to A[k], and then strictly decrease from A[k + 1] to the last element of the array. Thus creating a
 * "mountain" of numbers.
 * That is, given A[0]<...<A[k-1]<A[k]>A[k+1]>...>A[n-1], we need to find the index k. Note that the peak element
 * is neither the first nor the lastIndex of the array.
 *
 * Find the index of the peak element. Assume there is only one peak element.
 * SAMPLE DATA:
 * Input: 0 1 2 3 2 1 0
 *
 * Output: 3
 *
 * Explanation: The largest element is 3, and its index is 3.
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Binary Search
 * RUNTIME COMPLEXITY: O(logn)
 * SPACE COMPLEXITY: O(1)
 */
public class PeakMountainArray {

    public static int peakOfMountainArray(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            final int mid = (high + low) / 2;
            final int peak = arr.get(mid);
            final int left = (mid > 0) ? arr.get(mid - 1) : Integer.MIN_VALUE;  // Set left to a very small value if mid is 0
            final int right = (mid < arr.size() - 1) ? arr.get(mid + 1) : Integer.MIN_VALUE;  // Set right to a very small value if mid is at the last index
            if ((left < peak) && (right < peak)) {
                return mid;
            } else if (left > peak) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testCase1() {
        final List<Integer> input = List.of(0, 1, 2, 3, 2, 1, 0);
        final int expected = 3;
        final int actual = peakOfMountainArray(input);
        Assertions.assertEquals(expected, actual, "Index of the peak element");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = List.of(0, 10, 3, 2, 1, 0);
        final int expected = 1;
        final int actual = peakOfMountainArray(input);
        Assertions.assertEquals(expected, actual, "Index of the peak element");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = List.of(0, 10, 0);
        final int expected = 1;
        final int actual = peakOfMountainArray(input);
        Assertions.assertEquals(expected, actual, "Index of the peak element");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = List.of(0, 1, 2, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 112, 122, 132, 133, 132, 111, 0);
        final int expected = 16;
        final int actual = peakOfMountainArray(input);
        Assertions.assertEquals(expected, actual, "Index of the peak element");
    }
}
