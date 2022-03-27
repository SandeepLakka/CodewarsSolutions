package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Office V - Find a Chair

So you've found a meeting room - phew! You arrive there ready to present,
and find that someone has taken one or more of the chairs!!
You need to find some quick.... check all the other meeting rooms to see if all the chairs are in use.

Your meeting room can take up to 8 chairs. need will tell you how many have been taken.
You need to find that many.

Find the spare chairs from the array of meeting rooms.
Each meeting room tuple will have the number of occupants as a string.
Each occupant is represented by 'X'.
The room tuple will also have an integer telling you how many chairs there are in the room.

You should return an array of integers that shows how many chairs you take from each room in order,
up until you have the required amount.

example:

[['XXX', 3], ['XXXXX', 6], ['XXXXXX', 9], ['XXX',2]] when you need 4 chairs:

result -> [0, 1, 3] no chairs free in room 0, take 1 from room 1, take 3 from room 2.
no need to consider room 3 as you have your 4 chairs already.
If you need no chairs, return "Game On".
If there aren't enough spare chairs available, return "Not enough!".

Other Kata's:
The Office I - Outed
The Office II - Boredeom Score
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room

Categories : Fundamentals, Arrays, Strings
 */
public class TheOfficePart5 {
    @Test
    public void basic1() {
        Room[] rooms = new Room[]{
                new Room("XXX", 3),
                new Room("XXXXX", 6),
                new Room("XXXXXX", 9)
        };
        assertArrayEquals(new int[]{0, 1, 3}, (int[]) meeting(rooms, 4));
    }

    @Test
    public void basic2() {
        Room[] rooms = new Room[]{
                new Room("XXX", 1),
                new Room("XXXXXX", 6),
                new Room("X", 2),
                new Room("XXXXXX", 8),
                new Room("X", 3),
                new Room("XXX", 1)
        };
        assertArrayEquals(new int[]{0, 0, 1, 2, 2}, (int[]) meeting(rooms, 5));
    }

    @Test
    public void basic3() {
        Room[] rooms = new Room[]{
                new Room("XX", 2),
                new Room("XXXX", 6),
                new Room("XXXXX", 4)
        };
        assertEquals("Game On", meeting(rooms, 0));
    }

    public static Object meeting(Room[] x, int need) {
        final String GAME_ON = "Game On";
        final String NOT_ENOUGH = "Not enough!";
        if (need == 0) return GAME_ON;
        List<Integer> list = new ArrayList<>();
        boolean isFound = false;
        for (Room room : x) {
            int remaining = Math.max(0, room.chairs - room.occupants.length());
            if (need < remaining) {
                list.add(need);
                need = 0;
            } else {
                need -= remaining;
                list.add(remaining);
            }
            System.out.println(list);

            System.out.println(need);
            if (need <= 0) return list.stream().mapToInt(Integer::valueOf).toArray();
        }

        return NOT_ENOUGH;
    }

    private static class Room {
        final private String occupants;
        final private int chairs;

        public Room(String occupants, int seats) {
            this.occupants = occupants;
            this.chairs = seats;
        }
    }
}