package com.owodigi.sliding.window;

import java.util.*;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */
class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if ((i + 1) >= k) {
                max = Math.max(max, sum);
                sum -= arr[i - k + 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Expected: 9
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        // Expected: 7
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}