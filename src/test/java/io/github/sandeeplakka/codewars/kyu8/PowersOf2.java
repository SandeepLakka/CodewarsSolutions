package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Powers of 2

Complete the function that takes a non-negative integer n as input,
and returns a list of all the powers of 2 with the exponent ranging from 0 to n (inclusive).

Examples:
n = 0  ==> [1]        # [2^0]
n = 1  ==> [1, 2]     # [2^0, 2^1]
n = 2  ==> [1, 2, 4]  # [2^0, 2^1, 2^2]

Categories : Fundamentals

 */
public class PowersOf2 {

    @Test
    public void testSomething() {
        assertArrayEquals(new long[]{1}, powersOfTwo(0));
        assertArrayEquals(new long[]{1, 2}, powersOfTwo(1));
        assertArrayEquals(new long[]{1, 2, 4, 8, 16}, powersOfTwo(4));
    }

    public static long[] powersOfTwo(int n) {
        return LongStream.rangeClosed(0, n).map(val -> (1L << val)).toArray();
    }
}