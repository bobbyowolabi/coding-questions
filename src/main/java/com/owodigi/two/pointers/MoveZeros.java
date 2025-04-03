package com.owodigi.two.pointers;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Move Zeros
 * LEVEL: Easy 🟩
 * PROBLEM STATEMENT: Given an array of integers, move all the 0s to the back of the array while maintaining the
 * relative order of the non-zero elements. Do this in-place using constant auxiliary space.
 * SAMPLE DATA:
 * -------------------
 * STATUS: SOLVED ✅
 * PATTERN: Two Pointers
 *
 * RUNTIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(1)
 */
public class MoveZeros {

    public static void moveZeros(List<Integer> nums) {
        if (nums.size() < 2) {
            return;
        }
        int write = 0, read = 1;
        while (read < nums.size()) {
            if (nums.get(write) == 0 && nums.get(read) != 0) {
                nums.set(write, nums.get(read));
                nums.set(read, 0);
            }
            if (nums.get(write) != 0) {
                ++write;
            }
            ++read;
        }
    }

    @Test
    public void testCase1() {
    }
}
