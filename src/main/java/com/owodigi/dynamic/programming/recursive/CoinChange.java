package com.owodigi.dynamic.programming.recursive;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE:
 * LEVEL: Medium
 * STATUS: NOT SOLVED ❌
 * PROBLEM STATEMENT: You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 * SAMPLE DATA:
 */
public class CoinChange {

    public int coinChange(final int[] coins, final int amount) {
        if (amount == 0) {
            return 0;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; ++i) {
            if (coins[i] <= amount) {
                final int currentCount = coinChange(coins, amount - coins[i]);
                if ((currentCount != Integer.MAX_VALUE) && (currentCount + 1 < minCount)) {
                     minCount = currentCount + 1;
                }
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCount;
        }
    }

    private void test(final int[] input, final int amount, final int expected) {
        final int actual = coinChange(input, amount);
        Assertions.assertEquals(expected, actual, "number of coins");
    }

    @Test
    public void testCase1() {
        final int[] input = {186,419,83,408};
        final int amount = 6249;
        final int expected = 20;
        test(input, amount, expected);
    }

    @Test
    public void testCase2() {
        final int[] input = {1,2,5};
        final int amount = 11;
        final int expected = 3;
        test(input, amount, expected);
    }

    @Test
    public void testCase3() {
        final int[] input = {2};
        final int amount = 3;
        final int expected = -1;
        test(input, amount, expected);
    }

    @Test
    public void testCase4() {
        final int[] input = {1};
        final int amount = 0;
        final int expected = 0;
        test(input, amount, expected);
    }
}
