package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find the smallest integer in the array

Description:

Given an array of integers your solution should find the smallest integer.

For example:

    Given [34, 15, 88, 2] your solution will return 2
    Given [34, -345, -1, 100] your solution will return -345

You can assume, for the purpose of this kata,
that the supplied array will not be empty.

Categories : Fundamentals
 */
public class SmallestIntegerFinder {

    @Test
    public void test1() {
        assertEquals(8, findSmallestInt(new int[]{78, 56, 232, 12, 8}));
    }


    @Test
    public void test2() {
        assertEquals(-2, findSmallestInt(new int[]{78, 56, -2, 12, 8}));
    }

    @Test
    public void test3() {
        assertEquals(Integer.MIN_VALUE,
                findSmallestInt(new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    public void test4() {
        assertEquals(Integer.MIN_VALUE,
                findSmallestInt(new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    public void test5() {
        assertEquals(-321423,
                findSmallestInt(new int[]{-133, -5666, -89, -12341, -321423, Integer.MAX_VALUE}));
    }

    @Test
    public void test6() {
        assertEquals(Integer.MIN_VALUE,
                findSmallestInt(new int[]{0, Integer.MAX_VALUE,
                        Integer.MIN_VALUE,
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE}));
    }

    @Test
    public void test7() {
        assertEquals(1,
                findSmallestInt(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void test8() {
        assertEquals(-10,
                findSmallestInt(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10}));
    }

    @Test
    public void test9() {
        assertEquals(-78,
                findSmallestInt(new int[]{-78, 56, 232, 12, 8}));
    }


    @Test
    public void test10() {
        assertEquals(-8,
                findSmallestInt(new int[]{78, 56, -2, 12, -8}));
    }

    public static int findSmallestInt(int[] args) {
        return IntStream.of(args).min().orElse(-1);
    }
}