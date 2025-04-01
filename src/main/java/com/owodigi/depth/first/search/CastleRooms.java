package com.owodigi.depth.first.search;

import java.io.*;
import java.util.*;

/*
You are with your friends in a castle, where there are multiple rooms named after flowers. Some of the rooms contain treasures - we call them the treasure rooms.

Each room contains a single instruction that tells you which room to go to next.

 *** instructions_1 and treasure_rooms_1 ***

 lily* ---------      daisy  sunflower
               |        |     |
               v        v     v
 jasmin --> tulip*      violet* ----> rose* -->
            ^    |      ^             ^       |
            |    |      |             |       |
            ------    iris            ---------

* denotes a treasure room, e.g., rose is a treasure room, but jasmin isn't.

This is given as a list of pairs of (source_room, destination_room)

instructions_1 = [
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"],
    ["rose", "rose"],
    ["violet", "rose"],
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]

Write a function that takes two parameters as input:
* a list containing the treasure rooms, and
* a list of instructions represented as pairs of (source_room, destination_room)

and returns a collection of all the rooms that satisfy the following two conditions:

* at least two *other* rooms have instructions pointing to this room
* this room's instruction immediately points to a treasure room

filter_rooms(instructions_1, treasure_rooms_1) => ["tulip", "violet"]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (tulip itself)
* violet can be accessed from daisy, sunflower and iris. Violet's instruction points to a treasure room (rose)

Additional inputs

treasure_rooms_2 = ["lily", "jasmin", "violet"]

filter_rooms(instructions_1, treasure_rooms_2) => []
* none of the rooms reachable from tulip or violet are treasure rooms

 *** instructions_2 and treasure_rooms_3 ***

 lily ---------          --------
              |          |      |
              v          v      |
 jasmin --> tulip ---> violet*--^

instructions_2 = [
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "violet"],
    ["violet", "violet"]
]

treasure_rooms_3 = ["violet"]


Map<String, Set<String>>
[Tulip, <jasmin, lily>]
[violet, <tulip, violet>]

Map<String, String> roomMap;
Set<String> treasures

List<String> path, boolean seenTreasureRoom,



filter_rooms(instructions_2, treasure_rooms_3) => [tulip]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (violet)

All the test cases:
filter_rooms(instructions_1, treasure_rooms_1)    => ["tulip", "violet"]
filter_rooms(instructions_1, treasure_rooms_2)    => []
filter_rooms(instructions_2, treasure_rooms_3)    => [tulip]

Complexity Analysis variables:
T: number of treasure rooms
I: number of instructions given
*/

public class CastleRooms {

    private static void populate(final String[][] instructions_1, final Map<String, String> roomMap, final Map<String, Set<String>> reverseLookupMap) {
        for (final String[] instruction : instructions_1) {
            final String source = instruction[0];
            final String destination = instruction[1];
            roomMap.put(source, destination);
            Set<String> sourceRooms = reverseLookupMap.get(destination);
            if (sourceRooms == null) {
                sourceRooms = new HashSet<>();
                reverseLookupMap.put(destination, sourceRooms);
            }
            sourceRooms.add(source);
        }
    }

    private static void visit(final String source, final Map<String, String> roomMap, final Map<String, Set<String>> reverseLookupMap, final Set<String> treasureRooms, final Set<String> visited, final Set<String> results){
        if (source == null || visited.contains(source)) {
            return;
        }
        visited.add(source);
        final Set<String> sourceRooms = reverseLookupMap.get(source);
        final boolean pointsToSelf = sourceRooms != null && sourceRooms.contains(source);
        if (sourceRooms != null) {
            sourceRooms.remove(source);
        }
        final boolean atLeastTwoSourceRooms = sourceRooms != null && sourceRooms.size() >= 2;
        final String destination = roomMap.get(source);
        final boolean pointsToTreasureRoom = (destination != null && treasureRooms.contains(destination)) || (treasureRooms.contains(source) && pointsToSelf);

        if (atLeastTwoSourceRooms && pointsToTreasureRoom) {
            results.add(source);
        }

        visit(destination, roomMap,reverseLookupMap, treasureRooms,  visited, results);
    }

    public static Set<String> filter_rooms(final String[][] instructions_1, final String[] treasure_rooms_1) {
        final Map<String, String> roomMap = new HashMap<>();
        final Map<String, Set<String>> reverseLookupMap = new HashMap<>();
        final Set<String> results = new HashSet<>();
        final Set<String> visited = new HashSet<>();
        final Set<String> treasureRooms = new HashSet<>();
        Collections.addAll(treasureRooms, treasure_rooms_1);
        populate(instructions_1, roomMap, reverseLookupMap);
        for (final String room : roomMap.keySet()) {
            visit(room, roomMap, reverseLookupMap, treasureRooms, visited, results);
        }
        return results;
    }

    public static void main(String[] argv) {
        // Inputs
        String[][] instructions_1 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "tulip"},
                {"rose", "rose"},
                {"violet", "rose"},
                {"sunflower", "violet"},
                {"daisy", "violet"},
                {"iris", "violet"}
        };

        String[][] instructions_2 = {
                {"jasmin", "tulip"},
                {"lily", "tulip"},
                {"tulip", "violet"},
                {"violet", "violet"}
        };

        String[] treasure_rooms_1 = {"lily", "tulip", "violet", "rose"};
        String[] treasure_rooms_2 = {"lily", "jasmin", "violet"};
        String[] treasure_rooms_3 = {"violet"};


        System.out.println(filter_rooms(instructions_1, treasure_rooms_1));
    }
}
