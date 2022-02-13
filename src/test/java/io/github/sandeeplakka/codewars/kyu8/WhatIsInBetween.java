package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
What is between?

Complete the function that takes two integers (a, b, where a < b) and
return an array of all integers between the input parameters, including them.

For example:
a = 1
b = 4
--> [1, 2, 3, 4]

Categories : Fundamentals, Algorithms

 */
public class WhatIsInBetween {

    @Test
    public void basicTests() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, between(1, 4));
        assertArrayEquals(new int[]{-2, -1, 0, 1, 2}, between(-2, 2));
        assertArrayEquals(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                between(-10, 10));
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
                75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                100}, between(5, 100));
    }

    public static int[] between(int a, int b) {
        return IntStream.rangeClosed(a, b).toArray();
    }
}