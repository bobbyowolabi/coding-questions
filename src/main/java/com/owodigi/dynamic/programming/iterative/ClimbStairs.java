package com.owodigi.dynamic.programming.iterative;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Climbing Stairs
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: You are climbing a staircase. It takes n steps to reach the top.  Each time you can either
 * climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * SAMPLE DATA:
 * Input: n = 2
 * Output: 2
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        final int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    @Test
    public void testCase1() {
    }
}
