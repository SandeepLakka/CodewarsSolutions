package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
Find the first non-consecutive number

Your task is to find the first element of an array that is not consecutive.
By not consecutive we mean not exactly 1 larger than the previous element of the array.
E.g. If we have an array [1,2,3,4,6,7,8] then 1 then 2 then 3 then 4 are all consecutive but 6 is not,
so that's the first non-consecutive number.

If the whole array is consecutive then return null.
The array will always have at least 2 elements1 and all elements will be numbers.
The numbers will also all be unique and in ascending order.
The numbers could be positive or negative and the first non-consecutive could be either too!

Categories : Arrays, Fundamentals
 */
class FirstNonConsecutive {

    @Test
    public void basicTests() {
        assertNull(find(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(Integer.valueOf(6), find(new int[]{4, 6, 7, 8, 9, 11}));
        assertEquals(Integer.valueOf(11), find(new int[]{4, 5, 6, 7, 8, 9, 11}));
        assertNull(find(new int[]{31, 32}));
        assertEquals(Integer.valueOf(0), find(new int[]{-3, -2, 0, 1}));
        assertEquals(Integer.valueOf(-1), find(new int[]{-5, -4, -3, -1}));
    }

    static Integer find(final int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i - 1] - array[i]) != 1) {
                return array[i];
            }
        }

        return null;
    }
}
