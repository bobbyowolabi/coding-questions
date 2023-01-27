package com.owodigi.cyclic.sort;

/**
 * Status: Not Completed
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 */
class FindDuplicate {

    private static boolean swap(final int a, final int b, final int[] nums) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return nums[a] == nums[b];
    }

    // [1, 4, 4, 3, 2]
    // [1, 3, 4, 4, 2]
    // [1, 4, 3, 4, 2]
    public static int findNumber(final int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                if (swap(i, nums[i] - 1, nums)) {
                    return nums[i];
                }
            } else {
                ++i;
            }
        }
        return -1;
    }
}
