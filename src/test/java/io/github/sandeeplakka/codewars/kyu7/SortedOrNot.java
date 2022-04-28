package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sorted? yes? no? how?

Complete the method which accepts an array of integers, and returns one of the following:

    "yes, ascending" - if the numbers in the array are sorted in an ascending order
    "yes, descending" - if the numbers in the array are sorted in a descending order
    "no" - otherwise

You can assume the array will always be valid, and there will always be one correct answer.

Categories : Fundamentals, Arrays, Sorting, Algorithms

 */
class SortedOrNot {

    @Test
    public void testForAscending() {
        assertEquals("yes, ascending", isSortedAndHow(new int[]{1, 3, 5, 6, 7}));
        assertEquals("yes, ascending", isSortedAndHow(new int[]{1, 10, 100}));
    }

    @Test
    public void testForDescending() {
        assertEquals("yes, descending", isSortedAndHow(new int[]{100, 30, 15, 6}));
        assertEquals("yes, descending", isSortedAndHow(new int[]{100, 10, 1}));
    }

    @Test
    public void testForEquals() {
        assertEquals("no", isSortedAndHow(new int[]{1, 3, 5, 6, 2}));
        assertEquals("no", isSortedAndHow(new int[]{1, 10, 5}));
    }


    //FIXME : YTD
    public static String isSortedAndHow(int[] array) {
        final String NO = "no";
        final String ASCENDING = "yes, ascending";
        final String DESCENDING = "yes, descending";
        if (array == null) return "no";

        for (int i = 1; i < array.length; i++) {
            if (array[i] > 1) {
            }
        }
        boolean isSorted;

        return "";
    }

}