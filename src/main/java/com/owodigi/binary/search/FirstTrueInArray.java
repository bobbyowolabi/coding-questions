package com.owodigi.binary.search;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Find the First True in a Sorted Boolean Array
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: An array of boolean values is divided into two sections: The left section consists of all false,
 * and the right section consists of all true. Find the First True in a Sorted Boolean Array of the right section, i.e.,
 * the index of the first true element. If there is no true element, return -1.
 *
 * SAMPLE DATA:
 *  Input: arr = [false, false, true, true, true]
 *  Output: 2
 *  Explanation: The first true's index is 2.
 *
 * -------------------
 * STATUS: SOLVED ✅
 * RUNTIME COMPLEXITY: O(logn)
 * SPACE COMPLEXITY: O(1)
 */
public class FirstTrueInArray {

    public static int findBoundary(List<Boolean> arr) {
        int left = 0, right = arr.size() - 1;
        int lastTrueIndex = -1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr.get(mid)) {
                lastTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return lastTrueIndex;
    }

    @Test
    public void testCase1() {
        final List<Boolean> input = Arrays.asList(false, false, true, true, true);
        final int expected = 2;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }

    @Test
    public void testCase2() {
        final List<Boolean> input = Arrays.asList(true);
        final int expected = 0;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }

    @Test
    public void testCase3() {
        final List<Boolean> input = Arrays.asList(false, false, false);
        final int expected = -1;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }

    @Test
    public void testCase4() {
        final List<Boolean> input = Arrays.asList(true, true, true, true, true);
        final int expected = 0;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }

    @Test
    public void testCase5() {
        final List<Boolean> input = Arrays.asList(false, true);
        final int expected = 1;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }

    @Test
    public void testCase6() {
        final List<Boolean> input = Arrays.asList(false, false, false, false, false, false, false, false, true);
        final int expected = 8;
        final int actual = findBoundary(input);
        Assertions.assertEquals(expected, actual, "The First Index With a True Value");
    }
}
