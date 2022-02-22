package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
A Rule of Divisibility by 7

A number m of the form 10x + y is divisible by 7 if and only if x − 2y is divisible by 7.
In other words, subtract twice the last digit from the number formed by the remaining digits.
Continue to do this until a number known to be divisible by 7 is obtained;
you can stop when this number has at most 2 digits
because you are supposed to know if a number of at most 2 digits is divisible by 7 or not.

The original number is divisible by 7 if and only if
the last number obtained using this procedure is divisible by 7.

Examples:

1 : m = 371 -> 37 − (2×1) -> 37 − 2 = 35 ; thus, since 35 is divisible by 7, 371 is divisible by 7.
The number of steps to get the result is 1.
2 : m = 1603 -> 160 - (2 x 3) -> 154 -> 15 - 8 = 7 and 7 is divisible by 7.
3 : m = 372 -> 37 − (2×2) -> 37 − 4 = 33 ; thus, since 33 is not divisible by 7, 372 is not divisible by 7.

4 : m = 477557101->47755708->4775554->477547->47740->4774->469->28 and 28 is divisible by 7,
so is 477557101. The number of steps is 7.
Task:

Your task is to return to the function seven(m) (m integer >= 0)
an array of numbers, the first being the last number m with at most 2 digits
obtained by your function (this last m will be divisible or not by 7),
the second one being the number of steps to get the result.

Forth Note:
Return on the stack number-of-steps, last-number-m-with-at-most-2-digits

Examples:
seven(371) should return [35, 1]
seven(1603) should return [7, 2]
seven(477557101) should return [28, 7]

Categories : Fundamentals
 */
class DivSeven {

    @Test
    @DisplayName("Basic Tests")
    public void test1() {
        assertArrayEquals(new long[]{10, 2}, seven(1021));
        assertArrayEquals(new long[]{28, 7}, seven(477557101));
        assertArrayEquals(new long[]{47, 7}, seven(477557102));
        assertArrayEquals(new long[]{21, 7}, seven(234002979));
        assertArrayEquals(new long[]{7, 2}, seven(1603));
        assertArrayEquals(new long[]{35, 1}, seven(371));
        assertArrayEquals(new long[]{0, 5}, seven(1369851));
        assertArrayEquals(new long[]{42, 1}, seven(483));
        assertArrayEquals(new long[]{28, 4}, seven(483595));
        assertArrayEquals(new long[]{0, 0}, seven(0));
        assertArrayEquals(new long[]{7, 2}, seven(286 * 7));

        assertArrayEquals(new long[]{10, 2}, sevenRecur(1021));
        assertArrayEquals(new long[]{28, 7}, sevenRecur(477557101));
        assertArrayEquals(new long[]{47, 7}, sevenRecur(477557102));
        assertArrayEquals(new long[]{21, 7}, sevenRecur(234002979));
        assertArrayEquals(new long[]{7, 2}, sevenRecur(1603));
        assertArrayEquals(new long[]{35, 1}, sevenRecur(371));
        assertArrayEquals(new long[]{0, 5}, sevenRecur(1369851));
        assertArrayEquals(new long[]{42, 1}, sevenRecur(483));
        assertArrayEquals(new long[]{28, 4}, sevenRecur(483595));
        assertArrayEquals(new long[]{0, 0}, sevenRecur(0));
        assertArrayEquals(new long[]{7, 2}, sevenRecur(286 * 7));

    }

    @Test
    @DisplayName("Just Random Numbers")
    public void test2() {
        assertArrayEquals(new long[]{-4, 5}, seven(1620557));
        assertArrayEquals(new long[]{51, 5}, seven(6428775));
        assertArrayEquals(new long[]{35, 5}, seven(4110491));
        assertArrayEquals(new long[]{-3, 5}, seven(1184091));
        assertArrayEquals(new long[]{45, 5}, seven(5376204));

        assertArrayEquals(new long[]{-4, 5}, sevenRecur(1620557));
        assertArrayEquals(new long[]{51, 5}, sevenRecur(6428775));
        assertArrayEquals(new long[]{35, 5}, sevenRecur(4110491));
        assertArrayEquals(new long[]{-3, 5}, sevenRecur(1184091));
        assertArrayEquals(new long[]{45, 5}, sevenRecur(5376204));
    }

    //can also be implemented recursively, iterative approach suits here
    public static long[] seven(long m) {
        long iter = 0;

        while (m >= 100) {
            iter++;
            m = m / 10 - 2 * (m % 10);
        }

        return new long[]{m, iter};
    }

    //recursive solution driver
    public static long[] sevenRecur(long m) {
        return sevenV1(m, 0);
    }

    //recursive approach
    private static long[] sevenV1(long m, long iter) {
        if (m < 100) return new long[]{m, iter};
        return sevenV1(m / 10 - 2 * (m % 10), iter + 1);
    }
}
