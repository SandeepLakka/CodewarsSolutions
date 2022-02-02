package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Beginner Series #2 Clock

Description:

Clock shows h hours, m minutes and s seconds after midnight.
Your task is to write a function which returns the time since midnight in milliseconds.

Example:

h = 0
m = 1
s = 1

result = 61000

Input constraints:
    0 <= h <= 23
    0 <= m <= 59
    0 <= s <= 59

Categories : Fundamentals
 */
public class Clock {

    @Test
    public void test1() {
        assertEquals(0, past(0, 0, 0));
        assertEquals(1000, past(0, 0, 1));
        assertEquals(3601000, past(1, 0, 1));
        assertEquals(61000, past(0, 1, 1));
    }

    public static int past(int h, int m, int s) {
        //Happy Coding! ^_^
        return h * 3600000 + m * 60000 + s * 1000;
    }
}