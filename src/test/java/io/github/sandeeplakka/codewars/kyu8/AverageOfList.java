package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Calculate average

Write a function which calculates the average of the numbers in a given list.

Note: Empty arrays should return 0.

Categories : Fundamentals, Functional Programming, Declarative Programming

 */
public class AverageOfList {
    private static final double DELTA = 1e-15;

    @Test
    public void testSomething() {
        assertEquals(1, find_average(new int[]{1, 1, 1}), DELTA);
        assertEquals(2, find_average(new int[]{1, 2, 3}), DELTA);
        assertEquals(2.5, find_average(new int[]{1, 2, 3, 4}), DELTA);
    }

    public static double find_average(int[] array) {
        return IntStream.of(array).average().orElse(0);
    }
}