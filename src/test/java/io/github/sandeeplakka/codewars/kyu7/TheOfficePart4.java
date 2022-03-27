package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Office IV - Find a Meeting Room

Your job at E-Corp is both boring and difficult. It isn't made any easier
by the fact that everyone constantly wants to have a meeting with you,
and that the meeting rooms are always taken!

In this kata, you will be given an array. Each value represents a meeting room.
Your job? Find the first empty one and return its index
(N.B. There may be more than one empty room in some test cases).

'X' --> busy
'O' --> empty
If all rooms are busy, return "None available!"


Other Kata's:

The Office I - Outed
The Office II - Boredeom Score
The Office III - Broken Photocopier
The Office V - Find a Chair

Categories : Fundamentals, Arrays

 */
public class TheOfficePart4 {

    @Test
    public void basic1() {
        assertEquals(1, meeting(new char[]{'X', 'O', 'X'}));

        assertEquals(1, meetingV1(new char[]{'X', 'O', 'X'}));
    }

    @Test
    public void basic2() {
        assertEquals(0, meeting(new char[]{'O', 'X', 'X', 'X', 'X'}));

        assertEquals(0, meetingV1(new char[]{'O', 'X', 'X', 'X', 'X'}));
    }

    @Test
    public void basic3() {
        assertEquals(2, meeting(new char[]{'X', 'X', 'O', 'X', 'X'}));

        assertEquals(2, meetingV1(new char[]{'X', 'X', 'O', 'X', 'X'}));
    }

    @Test
    public void basic4() {
        assertEquals("None available!", meeting(new char[]{'X', 'X', 'X', 'X', 'X'}));

        assertEquals("None available!", meetingV1(new char[]{'X', 'X', 'X', 'X', 'X'}));
    }

    @Test
    public void randomizedTests() {
        assertEquals(1, meeting(new char[]{'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}));
        assertEquals("None available!", meeting(new char[]{'X', 'X'}));
        assertEquals(0, meeting(new char[]{'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}));
        assertEquals(2, meeting(new char[]{'X', 'X', 'O'}));
        assertEquals(5, meeting(new char[]{'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'}));
        assertEquals(6, meeting(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}));

        assertEquals(1, meetingV1(new char[]{'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}));
        assertEquals("None available!", meetingV1(new char[]{'X', 'X'}));
        assertEquals(0, meetingV1(new char[]{'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}));
        assertEquals(2, meetingV1(new char[]{'X', 'X', 'O'}));
        assertEquals(5, meetingV1(new char[]{'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'}));
        assertEquals(6, meetingV1(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}));
    }

    public static Object meeting(char[] x) {
        final String NONE_AVAILABLE = "None available!";
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 'O') {
                return i;
            }
        }
        return NONE_AVAILABLE;
    }

    public static Object meetingV1(char[] x) {
        final String NONE_AVAILABLE = "None available!";

        int val = new String(x).indexOf('O');
        if (val == -1) return NONE_AVAILABLE;
        return val;
    }
}