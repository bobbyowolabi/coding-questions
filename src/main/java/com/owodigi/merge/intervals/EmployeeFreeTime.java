package com.owodigi.merge.intervals;

import java.util.*;


/**
 * Completed
 */
class EmployeeFreeTime {

    // [a] {b}
    // [a  {b}  ]
    // [a  {b]  }
    private static boolean overlap(final Interval a, final Interval b) {
        return a.start <= b.start && b.start <= a.end;
    }

    public static List<Interval> findEmployeeFreeTime(final List<List<Interval>> schedules) {
        final List<Interval> combinedSchedules = new ArrayList<>();
        for (final List<Interval> schedule : schedules) {
            combinedSchedules.addAll(schedule);
        }
        final List<Interval> result = new ArrayList<>();
        Collections.sort(combinedSchedules, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 0; i < combinedSchedules.size() - 1; ++i) {
            final Interval current = combinedSchedules.get(i);
            final Interval next = combinedSchedules.get(i + 1);
            if (overlap(current, next) == false) {
                result.add(new Interval(current.end, next.start));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
