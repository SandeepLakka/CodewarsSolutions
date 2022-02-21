package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Grasshopper - Summation

Summation

Write a program that finds the summation of every number from 1 to num.
The number will always be a positive integer greater than 0.

For example:

summation(2) -> 3
#1 + 2

summation(8) -> 36
#1 + 2 + 3 + 4 + 5 + 6 + 7 + 8

Categories : Fundamentals, Loops, Control Flow, Basic Language Features
 */
public class GrassHopperSummation {

    @Test
    public void test1() {
        assertEquals(1, summation(1));
    }

    @Test
    public void test2() {
        assertEquals(36, summation(8));
    }

    @Test
    public void test3() {
        assertEquals(253, summation(22));
    }

    @Test
    public void test4() {
        assertEquals(5050, summation(100));
    }

    @Test
    public void test5() {
        assertEquals(22791, summation(213));
    }


    public static int summation(int n) {
        return n * (n + 1) / 2;
    }
}