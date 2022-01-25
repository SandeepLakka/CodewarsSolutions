package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find the stray number

You are given an odd-length array of integers, in which all of them are the same, except for one single number.

Complete the method which accepts such an array, and returns that single different number.

The input array will always be valid! (odd-length >= 3)
Examples

[1, 1, 2] ==> 2
[17, 17, 3, 17, 17, 17, 17] ==> 3

Categories : Fundamentals, Numbers, Algorithms
 */
class FindTheStrayNumber {
    @Test
    public void simpleArray1() {
        assertEquals(2, stray(new int[]{1, 1, 2}));
        assertEquals(3, stray(new int[]{17, 17, 3, 17, 17, 17, 17}));
    }

    @Test
    public void firstItem() {
        assertEquals(8, stray(new int[]{8, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void lastItem() {
        assertEquals(0, stray(new int[]{1, 1, 1, 1, 1, 1, 0}));
    }

    @Test
    public void middleItem() {
        assertEquals(7, stray(new int[]{0, 0, 0, 7, 0, 0, 0}));
    }

    @Test
    public void fifthItem() {
        assertEquals(-6, stray(new int[]{-21, -21, -21, -21, -6, -21, -21}));
    }


    //xor does the magic
    static int stray(int[] numbers) {
        return Arrays.stream(numbers).reduce((left, right) -> left ^ right).getAsInt();
    }
}