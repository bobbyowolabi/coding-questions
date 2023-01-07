package com.owodigi.cyclic.sort;

class MissingNumber {

    public static int findMissingNumber(final int[] nums) {
        final int[] sortedNums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sortedNums[nums[i]] = nums[i];
        }
        for (int i = 0; i < sortedNums.length; ++i) {
            if (sortedNums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Expect: 2
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        // Expect: 7
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
