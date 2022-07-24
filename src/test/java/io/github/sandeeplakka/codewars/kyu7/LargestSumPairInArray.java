package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Largest pair sum in array

Given a sequence of numbers, find the largest pair sum in the sequence.

For example:
[10, 14, 2, 23, 19] -->  42 (= 23 + 19)
[99, 2, 2, 23, 19]  --> 122 (= 99 + 23)

Input sequence contains minimum two elements and every element is an integer.

Categories : Fundamentals

 */
public class LargestSumPairInArray {
    @Test
    public void basicTestCases() {
        assertEquals(42, largestPairSum(new int[]{10, 14, 2, 23, 19}), "Failed test case [10, 14, 2, 23, 19]:");
        assertEquals(0, largestPairSum(new int[]{-100, -29, -24, -19, 19}), "Failed test case [-100, -29, -24, -19, 19]:");
        assertEquals(10, largestPairSum(new int[]{1, 2, 3, 4, 6, -1, 2}), "Failed test case [1, 2, 3, 4, 6, -1, 2]:");
        assertEquals(-18, largestPairSum(new int[]{-10, -8, -16, -18, -19}), "Failed test case [-10, -8, -16, -18, -19]:");
    }

    public static int largestPairSum(int[] numbers) {
        // your code here
        //Used streams to not mutate the input array
        if (numbers.length <= 2) return IntStream.of(numbers).sum();
        return IntStream.of(numbers).sorted().skip(numbers.length - 2).sum();

    }
}