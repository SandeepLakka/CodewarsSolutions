package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Largest 5 digit number in a series

In the following 6 digit number: 283910
91 is the greatest sequence of 2 consecutive digits.

In the following 10 digit number: 1234567890
67890 is the greatest sequence of 5 consecutive digits.

Complete the solution so that it returns the greatest sequence of
five consecutive digits found within the number given.
The number will be passed in as a string of only digits.
It should return a five digit integer. The number passed may be as large as 1000 digits.
Adapted from ProjectEuler.net

Categories : Algorithms

 */
public class LargestFiveDigitNumber {
    @Test
    public void exampleTests() {
        doTest("283910", 83910);
        doTest("1234567890", 67890);
        doTest("731674765", 74765);
    }

    private void doTest(String input, int expected) {
        assertEquals(expected, solve(input), "Solve : " + input);
        assertEquals(expected, solveV2(input), "Solve v2 : " + input);
    }

    public static int solve(final String digits) {
        int val = 0;
        for (int i = 0; i <= digits.length() - 5; i++) {
            int thisVal = Integer.parseInt(digits.substring(i, i + 5));
            val = Math.max(val, thisVal);
        }
        return val;
    }

    public static int solveV2(final String digits) {
        return IntStream.range(0, digits.length() - 4)
                .mapToObj(value -> digits.substring(value, value + 5))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(-1);
    }
}