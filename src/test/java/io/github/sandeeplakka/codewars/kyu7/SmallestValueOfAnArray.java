package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Smallest value of an array

Write a function that can return the smallest value of an array or the index of that value.
The function's 2nd parameter will tell whether it should return the value or the index.

Assume the first parameter will always be an array filled with at least 1 number and no duplicates.
Assume the second parameter will be a string holding one of two values: 'value' and 'index'.

findSmallest(new int[]{1,2,3,4,5}, 'value') // => 1
findSmallest(new int[]{1,2,3,4,5}, 'index') // => 0

Categories : Fundamentals, Arrays
 */
public class SmallestValueOfAnArray {
    @Test
    public void testSample() {
        assertEquals(0, findSmallest(new int[]{1, 2, 3}, "index"), "The smallest index");
        assertEquals(2, findSmallest(new int[]{7, 12, 3, 2, 27}, "value"), "The smallest index");
        assertEquals(3, findSmallest(new int[]{7, 12, 3, 2, 27}, "index"), "The smallest index");
    }

    public static int findSmallest(final int[] numbers, final String toReturn) {
        final String INDEX = "index";
        int minIdx = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[minIdx] > numbers[i]) {
                minIdx = i;
            }
        }
        return toReturn.equals(INDEX) ? minIdx : numbers[minIdx];

    }
}