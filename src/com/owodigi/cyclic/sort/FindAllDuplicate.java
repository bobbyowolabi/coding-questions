package com.owodigi.cyclic.sort;

import java.util.*;

/**
 * Status: Completed but don't fully understand
 * We are given an unsorted array containing n numbers taken from the range 1 to n. The array has some numbers appearing twice, find all these duplicate numbers using constant space.
 */
class FindAllDuplicate {

    private static void swap(final int a, final int b, final int[] nums) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static List<Integer> findNumbers(final int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            }
        }
        final List<Integer> duplicateNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                duplicateNumbers.add(nums[i]);
            }
        }
        return duplicateNumbers;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
