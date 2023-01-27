package com.owodigi.sliding.window;

/**
 * Given an array of positive integers and a number ‘S,’ find the length of the
 * smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 */
class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; ++i) {
            int j = i;
            int sum = 0;
            while (j < arr.length) {
                sum += arr[j++];
                if (sum >= S) {
                    final int length = j - i;
                    if (min == 0) {
                        min = length;
                    } else {
                        min = Math.min(min, length);
                    }
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // Expected: 2
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        // Expected: 3
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
        // Expected: 3
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        // Expected: 1
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
    }
}
