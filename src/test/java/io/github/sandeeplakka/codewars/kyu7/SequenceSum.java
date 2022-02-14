package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sum of numbers from 0 to N

Description:
We want to generate a function that computes the series starting from 0 and ending until the given number.

Examples:

Input:
6
Output:
"0+1+2+3+4+5+6 = 21"

Input:
-15
Output:
"-15<0"

Input:
0
Output:
"0=0"

Categories : Fundamentals, Loops, Control Flow, Basic Language Features, Sequences, Arrays
 */
public class SequenceSum {

    @Test
    public void testBasic() {
        assertEquals("0+1+2+3+4+5+6 = 21", showSequence(6));
        assertEquals("-15<0", showSequence(-15));
        assertEquals("0=0", showSequence(0));
        assertEquals("0+1+2+3+4+5+6+7+8+9+10+11 = 66", showSequence(11));
    }

    public static String showSequence(int value) {
        if (value == 0) return "0=0";
        if (value < 0) return value + "<0";

        return IntStream.rangeClosed(0, value)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("+")) +
                " = " +
                value * (value + 1) / 2;
    }
}