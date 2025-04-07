package com.owodigi.sliding.window;

import java.util.*;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */
class MaxSumFixedSubArray2 extends MaxSumFixedSubArray {
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

    @Override
    public int subarraySumFixed(final List<Integer> nums, final int k) {
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        return findMaxSumSubArray(k, arr);
    }
}