package com.owodigi.two.pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public abstract class RemoveDuplicates {

    public abstract int remove(final List<Integer> arr);

    @Test
    public void testCase1() {
        final List<Integer> input = Arrays.asList(2, 3, 3, 3, 6, 9, 9);
        final int expected = 4;
        final int actual = remove(input);
        Assertions.assertEquals(expected, actual, "New length of list post removal of duplicates");
    }

    @Test
    public void testCase2() {
        final List<Integer> input = Arrays.asList(2, 2, 2, 11);
        final int expected = 2;
        final int actual = remove(input);
        Assertions.assertEquals(expected, actual, "New length of list post removal of duplicates");
    }

    @Test
    public void testCase3() {
        final List<Integer> input = Arrays.asList(0, 0, 1, 1, 1, 2, 2);
        final int expected = 3;
        final int actual = remove(input);
        Assertions.assertEquals(expected, actual, "New length of list post removal of duplicates");
    }

    @Test
    public void testCase4() {
        final List<Integer> input = Arrays.asList(1, 2, 3);
        final int expected = 3;
        final int actual = remove(input);
        Assertions.assertEquals(expected, actual, "New length of list post removal of duplicates");
    }

    @Test
    public void testCase5() {
        final List<Integer> input = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        final int expected = 1;
        final int actual = remove(input);
        Assertions.assertEquals(expected, actual, "New length of list post removal of duplicates");
    }
}
