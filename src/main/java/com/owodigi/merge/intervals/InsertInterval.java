package com.owodigi.merge.intervals;

import java.util.*;

import com.owodigi.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TITLE: Insert Interval
 * LEVEL: Medium
 * STATUS: SOLVED ✅
 * PROBLEM STATEMENT: You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * SAMPLE DATA:
 */
public class InsertInterval {

    private int[] merge(final int[] a, final int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        final List<int[]> results = new ArrayList<>();
        int i = 0;
        boolean added = false;
        for (; i < intervals.length; ++i) {
            final int[] interval = intervals[i];
            // before
            if (newInterval[1] < interval[0]) {
                results.add(newInterval);
                added = true;
                break;
            } else if (newInterval[0] > interval[1]) {
                results.add(interval);
            } else {
                final int[] merged = merge(newInterval, interval);
                newInterval = merged;
            }
        }
        // fill remaining array
        for (; i < intervals.length; ++i) {
            results.add(intervals[i]);
        }
        if (!added) {
            results.add(newInterval);
        }
        int[][] arr = new int[results.size()][2];
        results.toArray(arr);
        return arr;
    }

    @Test
    public void testCase1() {
        final int[][] input = {{1,3},{6,9}};
        final int[] newInterval = {2,5};
        final int[][] expected = {{1,5},{6,9}};
        final int[][] actual = insert(input, newInterval);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        final int[][] input = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        final int[] newInterval = {4,8};
        final int[][] expected = {{1,2},{3,10},{12,16}};
        final int[][] actual = insert(input, newInterval);
        Assert.assertEquals(expected, actual);
    }
}
