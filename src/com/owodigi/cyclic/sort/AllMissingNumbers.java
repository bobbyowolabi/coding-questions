package com.owodigi.cyclic.sort;

import java.util.*;

class AllMissingNumbers {

    private static void swap(final int a, final int b, final int[] nums) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void sort(final int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            }
        }
    }

    public static List<Integer> findNumbers(int[] nums) {
        sort(nums);
        final List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 1, 5, 6, 4, 3, 2, 5, 5 });
        System.out.println("Missing numbers: " + missing + "\n");

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing + "\n");

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing + "\n");

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing + "\n");
    }
}
