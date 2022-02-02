package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Invert values

Given a set of numbers, return the additive inverse of each.
Each positive becomes negatives, and the negatives become positives.

invert([1,2,3,4,5]) == [-1,-2,-3,-4,-5]
invert([1,-2,3,-4,5]) == [-1,2,-3,4,-5]
invert([]) == []

Categories : Fundamentals, Integers, Numbers, Lists, Data Structures

 */
public class InvertValues {
    @Test
    public void testSomething() {

        int[] input = new int[]{-1, -2, -3, -4, -5};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        assertEquals(Arrays.toString(expected), Arrays.toString(invert(input)));

        input = new int[]{-1, 2, -3, 4, -5};
        expected = new int[]{1, -2, 3, -4, 5};
        assertEquals(Arrays.toString(expected), Arrays.toString(invert(input)));

        input = new int[]{};
        expected = new int[]{};
        assertEquals(Arrays.toString(expected), Arrays.toString(invert(input)));

        input = new int[]{0};
        expected = new int[]{0};
        assertEquals(Arrays.toString(expected), Arrays.toString(invert(input)));
    }

    public static int[] invert(int[] array) {
        return IntStream.of(array).map(Math::negateExact).toArray();
    }
}