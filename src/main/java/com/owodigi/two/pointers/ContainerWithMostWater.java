package com.owodigi.two.pointers;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Container With Most Water
 * LEVEL: Medium 🟨
 * PROBLEM STATEMENT: Given an array representing heights of vertical lines, find the maximum area of water trapped
 * between two lines.
 * SAMPLE DATA:
 * Input: [1,8,6,2,5,4,8,3,7].
 *
 * Output: 49
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Two Pointers
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class ContainerWithMostWater {

    public static int containerWithMostWater(List<Integer> arr) {
        int left = 0, right = arr.size() - 1, maxArea = -1;
        while (left < right) {
            final int height = Math.min(arr.get(left), arr.get(right));
            final int width = right - left;
            final int area = width * height;
            maxArea = Math.max(maxArea, area);
            if (arr.get(left) < arr.get(right)) {
                ++left;
            } else {
                --right;
            }
        }
        return maxArea;
    }

    private void test(final List<Integer> input , final int expected) {
        final int actual = containerWithMostWater(input);
        Assertions.assertEquals(expected, actual, "Maximum area of water trapped between two lines");
    }

    @Test
    public void testCase1() {
        test(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7), 49);
    }

    @Test
    public void testCase2() {
        test(List.of(1, 1), 1); // Only two lines: min(1,1) * (1 - 0) = 1
    }

    @Test
    public void testCase3() {
        test(List.of(4, 3, 2, 1, 4), 16); // Max area between index 0 and 4: min(4,4) * 4 = 16
    }

    @Test
    public void testCase4() {
        test(List.of(1, 2, 1), 2); // Max area between index 0 and 2: min(1,1) * 2 = 2
    }

    @Test
    public void testCase5() {
        test(List.of(2, 3, 10, 5, 7, 8, 9), 36); // Max area between index 2 and 6: min(10,9) * 4 = 36
    }

    @Test
    public void testCase6() {
        test(List.of(1, 3, 2, 5, 25, 24, 5), 24); // Max area between index 4 and 6: min(25,5) * 2 = 10
        // Better area: index 1 and 5: min(3,24) * 4 = 12
        // Best: index 3 and 4: min(5,25) * 1 = 5 — Not enough
        // Actually max is between 3 and 5: min(5,24) * 2 = 10
        // Best is between 1 and 5: 3*4=12 OR 4 and 5: 24*1 = 24
    }

    @Test
    public void testCase7() {
        test(List.of(10, 9, 8, 7, 6, 5), 25); // Max area: index 0 and 5: min(10,5)*5 = 25
    }

    @Test
    public void testCase8() {
        test(List.of(1, 2, 4, 3), 4); // Max area: index 1 and 2: min(2,4) * 1 = 2, index 0 and 2 = 2
        // index 0 and 3: 1 * 3 = 3, index 1 and 3: 2 * 2 = 4 (best)
    }
}
