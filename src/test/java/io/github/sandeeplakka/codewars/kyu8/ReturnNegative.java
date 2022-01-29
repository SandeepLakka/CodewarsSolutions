package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Return Negative

Description:

In this simple assignment you are given a number and have to make it negative.
But maybe the number is already negative?

Examples
makeNegative(1); // return -1
makeNegative(-5); // return -5
makeNegative(0); // return 0

Notes
    The number can be negative already, in which case no change is required.
    Zero (0) is not checked for any specific sign.
    Negative zeros make no mathematical sense.

Categories : Fundamentals, Numbers

 */
public class ReturnNegative {

    @Test
    public void test1() {
        assertEquals(-42, makeNegative(42));
    }

    @Test
    public void test2() {
        assertEquals(-9, makeNegative(-9));
    }

    @Test
    public void test3() {
        assertEquals(0, makeNegative(0));
    }

    @Test
    public void test4() {
        assertEquals(-1, makeNegative(1));
    }

    @Test
    public void test5() {
        assertEquals(-1, makeNegative(-1));
    }

    //Could've done exotic or golfed version of it but please bear with me
    public static int makeNegative(final int x) {
        return x < 0 ? x : -x;
    }

}