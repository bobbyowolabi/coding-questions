package com.owodigi.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Best Time to Buy and Sell Stock
 * LEVEL: Easy
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * SAMPLE DATA:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
public class BuySellStock {

    public int maxProfit(final int[] prices) {
        int maxProfit = 0;
        if (prices != null && prices.length < 2) {
            return maxProfit;
        }
        int buy = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            final int sell = prices[i];
            final int profit = sell - buy;
            maxProfit = Math.max(maxProfit, profit);
            if (sell < buy) {
                buy = sell;
            }
        }
        return maxProfit;
    }

    @Test
    public void testCase1() {
        final int[] input = {7,1,5,3,6,4};
        final int expected = 5;
        final int actual = maxProfit(input);
        Assertions.assertEquals(expected, actual, "Max Profit");
    }

    @Test
    public void testCase2() {
        final int[] input = {7,6,4,3,1};
        final int expected = 0;
        final int actual = maxProfit(input);
        Assertions.assertEquals(expected, actual, "Max Profit");
    }
}
