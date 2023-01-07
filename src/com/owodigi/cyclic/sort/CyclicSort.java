package com.owodigi.cyclic.sort;

/**
 * We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * O(n)
 *  and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
 */
class CyclicSort {

    private static void swap(final int a, final int b, final int[] nums) {
        final int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sort(final int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i + 1) {
                swap(i, nums[i] - 1, nums);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}