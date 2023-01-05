package com.owodigi.merge;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

// Go through each interval and create groups of intervals that do not intersect
class MinimumMeetingRooms {


    private static boolean conflict(final Meeting meeting, List<Meeting> meetingGroup) {
        final Meeting a = meetingGroup.get(meetingGroup.size() - 1);
        final Meeting b = meeting;
        return b.start < a.end;
    }

    // Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
    public static int findMinimumMeetingRooms(final List<Meeting> meetings) {
        if (meetings == null) {
            return 0;
        } else if (meetings.size() == 1) {
            return 1;
        }
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        final List<List<Meeting>> meetingGroups = new ArrayList<List<Meeting>>();
        for (int i = 0; i < meetings.size(); ++i) {
            final Meeting meeting = meetings.get(i);
            boolean foundMeetingGroup = false;
            for (int j = 0; j < meetingGroups.size(); ++j) {
                final List<Meeting> meetingGroup = meetingGroups.get(j);
                if (conflict(meeting, meetingGroup) == false) {
                    meetingGroup.add(meeting);
                    foundMeetingGroup = true;
                    break;
                }
            }
            if (foundMeetingGroup == false) {
                final List<Meeting> newMeetingGroup = new ArrayList<Meeting>();
                newMeetingGroup.add(meeting);
                meetingGroups.add(newMeetingGroup);
            }
        }
        return meetingGroups.size();
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
