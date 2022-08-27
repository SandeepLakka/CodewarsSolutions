package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Terminal game move function

In this game, the hero moves from left to right.
The player rolls the dice and moves the number of spaces indicated by the dice two times.

Create a function for the terminal game that takes the current position of the hero
and the roll (1-6) and return the new position.

Example:
move(3, 6) should equal 15

Categories : Fundamentals
 */
public class Move {

    @Test
    public void basicTests() {
        assertEquals(8, move(0, 4));
        assertEquals(15, move(3, 6));
        assertEquals(12, move(2, 5));
    }

    public static int move(int position, int roll) {
        return position + (roll << 1);
    }
}