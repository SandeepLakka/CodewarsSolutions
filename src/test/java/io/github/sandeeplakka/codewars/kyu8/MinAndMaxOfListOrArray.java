package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find Maximum and Minimum Values of a List

Your task is to make two functions (max and min, or maximum and minimum, etc., depending on the language) 
that receive a list of integers as input and return, respectively, the largest and lowest number in that list.

Examples (Input -> Output)

* [4,6,2,1,9,63,-134,566]         -> max = 566, min = -134
* [-52, 56, 30, 29, -54, 0, -110] -> min = -110, max = 56
* [42, 54, 65, 87, 0]             -> min = 0, max = 87
* [5]                             -> min = 5, max = 5

Notes
    You may consider that there will not be any empty arrays/vectors.

Categories: Fundamentals, Basic Language Features
 */
public class MinAndMaxOfListOrArray {

    @Test
    public void testExamples() {
        assertEquals(-110, min(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(0, min(new int[]{42, 54, 65, 87, 0}));
        assertEquals(566, max(new int[]{4, 6, 2, 1, 9, 63, -134, 566}));
        assertEquals(5, max(new int[]{5}));
    }

    public int min(int[] list) {
        int result = Integer.MAX_VALUE;
        for (int val : list) {
            if (val < result) {
                result = val;
            }
        }
        return result;
    }

    public int max(int[] list) {
        return IntStream.of(list).max().getAsInt();
    }
}