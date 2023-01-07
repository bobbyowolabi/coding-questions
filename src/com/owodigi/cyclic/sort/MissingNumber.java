package com.owodigi.cyclic.sort;

/**
 * The key is that you have to ignore the value N when sorting the numbers
 */
class MissingNumber {

    private static void swap(final int a, final int b, final int[] nums) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int findMissingNumber(final int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] < nums.length && nums[i] != i) {
                swap(i, nums[i], nums);
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        // Expect: 2
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        // Expect: 7
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
