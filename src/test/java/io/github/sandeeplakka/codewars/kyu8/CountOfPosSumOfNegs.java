package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Count of positives / sum of negatives
Given an array of integers.

Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.

If the input array is empty or null, return an empty array.
Example

For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15],
you should return [10, -65].

Categories : Fundamentals, Arrays, Lists, Data Structures
Arithmetic, Mathematics, Algorithms, Numbers
 */
public class CountOfPosSumOfNegs {
    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[]{10, -65};
        assertArrayEquals(expectedResult,
                countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[]{8, -50};
        assertArrayEquals(expectedResult,
                countPositivesSumNegatives(new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }

    @Test
    public void countPositivesSumNegatives_InputNull() {
        int[] expectedResult = new int[]{};
        assertArrayEquals(expectedResult, countPositivesSumNegatives(null));
    }

    @Test
    public void countPositivesSumNegatives_InputEmpty() {
        int[] expectedResult = new int[]{};
        assertArrayEquals(expectedResult, countPositivesSumNegatives(new int[]{}));
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[]{};

        int sumPos = 0;
        int sumNeg = 0;

        for (int val : input) {
            if (val == 0) continue;
            if (val < 0) sumNeg += val;
            else sumPos++;
        }

        //return an array with count of positives and sum of negatives
        return new int[]{sumPos, sumNeg};
    }
}