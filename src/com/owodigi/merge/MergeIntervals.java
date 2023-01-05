package com.owodigi.merge;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    // Sort the List of intervals by the start value
    // add the first interval to the result set
    // traverse the list of intervals
    // if the current interval intersects with last seen interval, merge them
    // add interval to result set

    //functionality
    //intersect
    //merge
    //sort

    // [a]{b}
    // [a{b}]
    // [a{b] }
    // {b}[a]
    // {b[a]}
    // {b[a} ]
    private static boolean intersect(final Interval a, final Interval b) {
        return (a.start < b.start && b.start < a.end) || (b.start < a.start && a.start < b.end);
    }

    private static Interval merge(final Interval a, final Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }

    private static void sort(final List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    }

    private static int lastIndex(final List<Interval> intervals) {
        return intervals.size() - 1;
    }

    public static List<Interval> merge(final List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        sort(intervals);
        final List<Interval> mergedIntervals = new LinkedList<Interval>();
        mergedIntervals.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            final Interval current = intervals.get(i);
            final Interval last = mergedIntervals.get(lastIndex(mergedIntervals));
            if (intersect(current, last)) {
                mergedIntervals.remove(lastIndex(mergedIntervals));
                final Interval mergedInterval = merge(current, last);
                mergedIntervals.add(mergedInterval);
            } else {
                mergedIntervals.add(current);
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}